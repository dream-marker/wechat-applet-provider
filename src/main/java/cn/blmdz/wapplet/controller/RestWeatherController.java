package cn.blmdz.wapplet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.blmdz.wapplet.base.BaseVo;
import cn.blmdz.wapplet.base.Response;
import cn.blmdz.wapplet.services.sdk.HeweatherSDK;

@RestController
@RequestMapping(value="/api/weather")
public class RestWeatherController {
    private @Autowired HeweatherSDK heweatherSDK;
    
    /**
     * 获取天气
     */
    @RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<BaseVo<JSONObject, JSONObject>> weatherAll(HttpServletRequest request,
            @RequestParam("lat") Double lat,
            @RequestParam("lon") Double lon) {
//        UserUtil.getBaseUser(request);
        String location = lon + "," + lat;
        return Response.build(BaseVo.put(heweatherSDK.s6Weather(location), heweatherSDK.s6Air(location)));
    }

}
