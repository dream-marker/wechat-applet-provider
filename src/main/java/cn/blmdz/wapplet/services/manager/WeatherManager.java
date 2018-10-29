package cn.blmdz.wapplet.services.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherAirVo;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherCurrentVo;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherDailyDetailVo;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherDailyVo;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherHourlyVo;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherLifeStyleVo;
import cn.blmdz.wapplet.model.sdk.weather.vo.WeatherVo;
import cn.blmdz.wapplet.services.sdk.HeweatherSDK;

@Component
public class WeatherManager {
	private @Autowired HeweatherSDK sdk;
	
	public WeatherVo weather(String location) {
		JSONObject weatherObj = sdk.s6Weather(location);
		if (weatherObj == null) return null;
		
		JSONObject jsonObj = null;
		
		WeatherVo weather = new WeatherVo();
		
		/** ####当天天气#### */
		WeatherCurrentVo current = new WeatherCurrentVo();
		
		/** 背景图 */
//		current.setBgImg(bgImg);
		/** 背景色 */
//		current.setBgColor(bgColor);
		/** 图标 */
//		current.setIcon(icon);
		/** 温度 */
		current.setTemp(Integer.parseInt(weatherObj.getJSONObject("now").getString("fl")));
		/** 湿度 */
		current.setHumidity(Integer.parseInt(weatherObj.getJSONObject("now").getString("hum")));
		/** 天气 */
		current.setWeather(weatherObj.getJSONObject("now").getString("cond_txt"));
		/** 风向 */
		current.setWind(weatherObj.getJSONObject("now").getString("wind_spd"));
		/** 风力等级 */
		current.setWindLevel(weatherObj.getJSONObject("now").getString("wind_sc"));
		/** 天气更新时间 */
		current.setUpdateTime(weatherObj.getJSONObject("update").getString("loc"));
		
		weather.setCurrent(current);
		
		/** ####逐时预报#### */
		List<WeatherHourlyVo> hourly = Lists.newArrayList();
		WeatherHourlyVo hourlyVo = null;
		for (int i = 0; i < weatherObj.getJSONArray("hourly").size(); i++) {
			jsonObj = weatherObj.getJSONArray("hourly").getJSONObject(i);
			hourlyVo = new WeatherHourlyVo();
			/** 温度 */
			hourlyVo.setTemp(Integer.parseInt(jsonObj.getString("tmp")));
			/** 图标 */
//			hourlyVo.setIcon(icon);
			/** 天气 */
			hourlyVo.setWeather(jsonObj.getString("cond_txt"));
			/** 时间 */
			hourlyVo.setTime(jsonObj.getString("time"));
			hourly.add(hourlyVo);
		}
		
		weather.setHourly(hourly);
		
		/** ####3-10天预报#### */
		List<WeatherDailyVo> daily = Lists.newArrayList();
		WeatherDailyVo dailyVo = null;
		WeatherDailyDetailVo dailyDetailVo = null;
		for (int i = 0; i < weatherObj.getJSONArray("daily_forecast").size(); i++) {
			jsonObj = weatherObj.getJSONArray("daily_forecast").getJSONObject(i);
			dailyVo = new WeatherDailyVo();
			dailyDetailVo = new WeatherDailyDetailVo();

			/** 白天 */
			/** 温度 */
			dailyDetailVo.setTemp(Integer.parseInt(jsonObj.getString("tmp_max")));
			/** 图标 */
//			dailyDetailVo.setIcon(icon);
			/** 天气 */
			dailyDetailVo.setWeather(jsonObj.getString("cond_txt_d"));
			dailyVo.setDay(dailyDetailVo);
			
			dailyDetailVo = new WeatherDailyDetailVo();
			/** 夜里 */
			/** 温度 */
			dailyDetailVo.setTemp(Integer.parseInt(jsonObj.getString("tmp_min")));
			/** 图标 */
//			dailyDetailVo.setIcon(icon);
			/** 天气 */
			dailyDetailVo.setWeather(jsonObj.getString("cond_txt_n"));
			dailyVo.setNight(dailyDetailVo);
			
			/** 时间 */
			dailyVo.setTime(jsonObj.getString("date"));
			/** 风向 */
			dailyVo.setWind(jsonObj.getString("wind_dir"));
			/** 风力等级 */
			dailyVo.setWindLevel(jsonObj.getString("tmp_max"));
			
			daily.add(dailyVo);
		}
		
		weather.setDaily(daily);
		
		/** ####生活指数#### */
		List<WeatherLifeStyleVo> life = Lists.newArrayList();
		WeatherLifeStyleVo lifeVo = null;
		for (int i = 0; i < weatherObj.getJSONArray("lifestyle").size(); i++) {
			jsonObj = weatherObj.getJSONArray("lifestyle").getJSONObject(i);
			lifeVo = new WeatherLifeStyleVo();
			
			/** 显示名称 */
//			lifeVo.setName(name);
			/** 图标 */
//			lifeVo.setIcon(icon);
			/** 内容 */
			lifeVo.setInfo(jsonObj.getString("brf"));
			/** 详情 */
			lifeVo.setDetail(jsonObj.getString("txt"));
			
			life.add(lifeVo);
		}
		
		weather.setLife(life);

		JSONObject airObj = sdk.s6Air(location);
		
		if (airObj == null) return weather;
		
		/** ####当前空气质量#### */
		WeatherAirVo air = new WeatherAirVo();

		/** 显示名称 */
		air.setName(airObj.getJSONObject("air_now_city").getString("qlty"));
		/** 数值 */
		air.setNum(Integer.parseInt(airObj.getJSONObject("air_now_city").getString("pm25")));
		/** 颜色 */
//		air.setColor(color);
		
		weather.setAir(air);
		
		return weather;
	}
}
