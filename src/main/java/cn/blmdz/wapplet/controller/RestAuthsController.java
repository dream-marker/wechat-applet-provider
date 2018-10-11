package cn.blmdz.wapplet.controller;

import static org.apache.commons.codec.binary.Base64.decodeBase64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.kevinsawicki.http.HttpRequest;

import cn.blmdz.wapplet.base.BaseUser;
import cn.blmdz.wapplet.base.Response;
import cn.blmdz.wapplet.enums.EnumsError;
import cn.blmdz.wapplet.model.applet.WechatAppletSessionKeyRequest;
import cn.blmdz.wapplet.model.applet.WechatAppletSessionKeyResponse;
import cn.blmdz.wapplet.model.applet.WechatAppletUserInfoResponse;
import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel;
import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;
import cn.blmdz.wapplet.services.cache.SystemConfigCache;
import cn.blmdz.wapplet.services.manager.UserRecognitionManager;
import cn.blmdz.wapplet.services.service.UserService;
import cn.blmdz.wapplet.util.AESUtil;
import cn.blmdz.wapplet.util.JsonMapper;
import cn.blmdz.wapplet.util.UserUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 微信小程序用户识别
 */
@Slf4j
@RestController
@RequestMapping(value="/api/auth")
public class RestAuthsController {

    private @Autowired SystemConfigCache configCache;
    private @Autowired UserService userService;
    private @Autowired UserRecognitionManager userRecognitionManager;

    /**
     * 解析识别记录用户
     * @param request
     * @param code
     * @param iv
     * @param encryptedData
     * @return
     */
    @RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<BaseUser> auth(HttpServletRequest request,
    		@RequestParam("code") String code,
    		@RequestParam("iv") String iv,
    		@RequestParam("encryptedData") String encryptedData,
    		@RequestParam("need") Boolean need,
    		@RequestParam("channel") Integer channel) {
        BaseUser baseUser = UserUtil.getBaseUser(request);
        if (!need && baseUser != null) return Response.build(baseUser);
        
        if (StringUtils.isBlank(code)) return Response.error(EnumsError.ERROR_000002);

        if (channel == null) return Response.error(EnumsError.ERROR_000002);
        TableEnumUserThirdChannel channelThird = TableEnumUserThirdChannel.conversion(channel);
        if (channelThird == null) return Response.error(EnumsError.ERROR_000004);
        
        
        WechatAppletConfig config = configCache.getWechatAppletConfig(channelThird);
        HttpRequest reqSession = HttpRequest.get(
        		"https://api.weixin.qq.com/sns/jscode2session",
                new WechatAppletSessionKeyRequest(
                        config.getAppId(),
                        config.getAppSecret(),
                        code),
                false);

        baseUser = null;
        if (reqSession.ok()) {
            String body = reqSession.body();
            log.debug("jscode2session info. info: {}", body);
            WechatAppletSessionKeyResponse sessionResponse = JsonMapper.nonEmptyMapper().fromJson(body, WechatAppletSessionKeyResponse.class);
            
            baseUser = userService.findByAccount_2(sessionResponse.getOpenid());
            if (baseUser == null) baseUser = decryptToUser(sessionResponse.getSession_key(), iv, encryptedData, channelThird);
            if (baseUser == null) return Response.error(EnumsError.ERROR_000101);
            
            UserUtil.setBaseUser(request, baseUser);
            log.info("welcome {}! user: {}", baseUser.getNick(), baseUser);
        } else {
            log.error("jscode2session error.");
        }
        return Response.build(baseUser);
    }

    /**
     * 封装识别
     * @param key
     * @param iv
     * @param encryptedData
     * @return
     */
    private BaseUser decryptToUser(String key, String iv, String encryptedData, TableEnumUserThirdChannel channel) {
        WechatAppletUserInfoResponse response = decrypt(key, iv, encryptedData);
        if (response == null) return null;
        BaseUser baseUser = new BaseUser();
        baseUser.setAccount_1(response.getUnionId());
        baseUser.setAccount_2(response.getOpenId());
        baseUser.setGender(response.getGender());
        baseUser.setNick(response.getNickName());
        baseUser.setAvatar(response.getAvatarUrl());
        baseUser.setChannel(channel);
        
        return userRecognitionManager.recognition(baseUser);
    }
    
    /**
     * 用户数据解密
     * @param key
     * @param iv
     * @param encryptedData
     * @return
     */
    private static WechatAppletUserInfoResponse decrypt(String key, String iv, String encryptedData) {
        String json = new String(AESUtil.instance.decrypt(decodeBase64(encryptedData), decodeBase64(key), decodeBase64(iv), AESUtil.CIPHER_AES_CBC_PKCS7PADDING));
        if (StringUtils.isBlank(json)) return null;
        log.debug("wechat applet decrypt user. info: {}", json);
        return JsonMapper.nonEmptyMapper().fromJson(json, WechatAppletUserInfoResponse.class);
    }
}
