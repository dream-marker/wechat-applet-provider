package cn.blmdz.wapplet.services.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import cn.blmdz.wapplet.model.enums.TableEnumUserThirdChannel;
import cn.blmdz.wapplet.model.sysconfig.WechatAppletConfig;
import cn.blmdz.wapplet.model.vo.WechatAppletVo;
import cn.blmdz.wapplet.services.cache.SystemConfigCache;
import cn.blmdz.wapplet.services.cache.UserThirdCache;

@Service
public class AppService {
    
    private @Autowired SystemConfigCache configCache;
    private @Autowired UserThirdCache userThirdCache;

    public List<WechatAppletVo> list() {

        return Lists.newArrayList(TableEnumUserThirdChannel.values()).stream()
            .filter(
                item -> item.show()
            ).map(
                item -> {
                    WechatAppletConfig config = configCache.getWechatAppletConfig(item);
                    WechatAppletVo app = new WechatAppletVo();
                    app.setId(item.code());
                    app.setTypeEnum(item.type());
                    app.setShowName(config.getShowName());
                    app.setShowImage(config.getShowImage());
                    app.setShowOrder(config.getShowOrder());
                    app.setAd(StringUtils.isNotBlank(config.getAdImage()));
                    app.setAdImage(StringUtils.defaultIfBlank(config.getAdImage(), null));
                    app.setArouse(StringUtils.isNotBlank(config.getArouseUrl()));
                    app.setArouseUrl(StringUtils.defaultIfBlank(config.getArouseUrl(), null));
                    app.setPeople(userThirdCache.getAppPeopleCount(item));
                    return app;
            }).sorted(
                (a, b) -> a.getShowOrder().compareTo(b.getShowOrder())
            ).collect(Collectors.toList());
    }
    
}
