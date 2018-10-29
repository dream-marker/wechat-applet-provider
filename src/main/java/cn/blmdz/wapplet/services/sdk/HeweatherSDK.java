package cn.blmdz.wapplet.services.sdk;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;

import cn.blmdz.wapplet.model.enums.TableEnumSystemConfigType;
import cn.blmdz.wapplet.model.sdk.weather.enums.EnumsHeweather;
import cn.blmdz.wapplet.model.sysconfig.HeweatcherConfig;
import cn.blmdz.wapplet.services.cache.SystemConfigCache;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HeweatherSDK {
    
    @Setter
    private HeweatcherConfig config;
    private static final String URL_WEATHER = "https://free-api.heweather.com/s6/weather";
    private static final String URL_AIR ="https://api.heweather.com/s6/air";
    
    @Autowired
    public HeweatherSDK (SystemConfigCache systemConfigCache) {
        this.config = systemConfigCache.getHeweatcherConfig(TableEnumSystemConfigType.HE_WEATHER);
    }
    public HeweatherSDK (){}
    
    public JSONObject s6Weather(String location) {
        log.debug("weather location: {}", location);
        return weather(URL_WEATHER, location);
    }
    public JSONObject s6Air(String location) {
        log.debug("air location: {}", location);
        return weather(URL_AIR, location);
    }
    
    private JSONObject weather(String url, String location) {
        Map<String, String> maps = Maps.newHashMap();
        maps.put("location", location);
        maps.put("unit", "m");
        maps.put("lang", "zh");
        maps.put("username", config.getUser());
        maps.put("t", String.valueOf(System.currentTimeMillis()/1000));
        maps.put("sign", getSign(maps, config.getKey()));
        HttpRequest request = HttpRequest.post(url).form(maps);
        if (request.ok()) {
            String response = request.body();
            JSONObject obj = JSON.parseObject(response);
            if (obj == null) return null;
            if (obj.getJSONArray("HeWeather6") == null || obj.getJSONArray("HeWeather6").size() == 0 || obj.getJSONArray("HeWeather6").getJSONObject(0) == null) return null;
            
            return EnumsHeweather.OK.code().equals(obj.getJSONArray("HeWeather6").getJSONObject(0).getString("status")) ? obj.getJSONArray("HeWeather6").getJSONObject(0) : null;
        }
        return null;
    }

    @SuppressWarnings("restriction")
    public static String getSign(Map<String, String> params, String key) {
        return new sun.misc.BASE64Encoder().encode(
                Hashing.md5().hashString(
                    Joiner.on("&").join(
                        params.keySet().stream()
                        .filter(item -> StringUtils.isNotBlank(params.get(item)))
                        .sorted((a, b) -> a.compareTo(b))
                        .map(item -> { return item + "=" + params.get(item);})
                        .collect(Collectors.toList())
                    ) + key,
                    Charset.forName("UTF-8")).asBytes());
    }
}
