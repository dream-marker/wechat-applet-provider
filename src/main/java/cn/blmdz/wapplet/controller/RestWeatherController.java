package cn.blmdz.wapplet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.blmdz.wapplet.base.Response;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherVo;
import cn.blmdz.wapplet.services.manager.WeatherManager;

@RestController
@RequestMapping(value="/api/weather")
public class RestWeatherController {
    private @Autowired WeatherManager weatherManager;
    
    /**
     * 获取天气
     */
    @RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Response<WeatherVo> weatherAll(HttpServletRequest request,
            @RequestParam("lat") Double lat,
            @RequestParam("lon") Double lon) {
//        UserUtil.getBaseUser(request);
        String location = lon + "," + lat;
        
        return Response.build(weatherManager.weather(location));
    }

}
