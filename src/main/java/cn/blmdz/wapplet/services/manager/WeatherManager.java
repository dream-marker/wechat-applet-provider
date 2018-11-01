package cn.blmdz.wapplet.services.manager;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import cn.blmdz.wapplet.model.sdk.weather.enums.EnumsHeweatherCodeIcon;
import cn.blmdz.wapplet.model.sdk.weather.enums.EnumsHeweatherLifeStyle;
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
	
	private static Boolean isDay(String sr, String ss) {
		Calendar calendar = Calendar.getInstance();
		String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
		
		return time.compareTo(sr) >= 0 && time.compareTo(ss) < 0;
	}
	
	public WeatherVo weather(String location) {
		JSONObject weatherObj = sdk.s6Weather(location);
		if (weatherObj == null) return null;
		
		JSONObject jsonObj = null;
		EnumsHeweatherCodeIcon icon = null;
		EnumsHeweatherLifeStyle ls = null;
		Boolean day = null;
		
		WeatherVo weather = new WeatherVo();
		
		/** ####当天天气#### */
		WeatherCurrentVo current = new WeatherCurrentVo();
		day = isDay(
				weatherObj.getJSONArray("daily_forecast").getJSONObject(0).getString("sr"),
				weatherObj.getJSONArray("daily_forecast").getJSONObject(0).getString("ss")
				);
		icon = EnumsHeweatherCodeIcon.conversion(Integer.parseInt(weatherObj.getJSONObject("now").getString("cond_code")));
		
		/** 背景图 */
		current.setBgImg(day ? icon.dayBg() : icon.nightBg());
		/** 背景色 */
		current.setBgColor(day ? icon.dayBgColor() : icon.nightBgColor());
		/** 图标 */
		current.setIcon(day ? icon.dayIcon() : icon.nightIcon());
		/** 温度 */
		current.setTemp(Integer.parseInt(weatherObj.getJSONObject("now").getString("fl")));
		/** 湿度 */
		current.setHumidity(Integer.parseInt(weatherObj.getJSONObject("now").getString("hum")));
		/** 天气 */
		current.setWeather(weatherObj.getJSONObject("now").getString("cond_txt"));
		/** 风向 */
		current.setWind(weatherObj.getJSONObject("now").getString("wind_dir"));
		/** 风力等级 */
		current.setWindLevel(weatherObj.getJSONObject("now").getString("wind_sc"));
		/** 天气更新时间 */
		current.setUpdateTime(weatherObj.getJSONObject("update").getString("loc"));
		/** 场景类型 */
		current.setScenesType(icon.scenesType().code());
		/** 场景等级 */
		current.setScenesLevel(icon.scenesLevel());
		
		weather.setCurrent(current);
		
		/** ####逐时预报#### */
		List<WeatherHourlyVo> hourly = Lists.newArrayList();
		WeatherHourlyVo hourlyVo = null;
		for (int i = 0; i < weatherObj.getJSONArray("hourly").size(); i++) {
			jsonObj = weatherObj.getJSONArray("hourly").getJSONObject(i);
			hourlyVo = new WeatherHourlyVo();
			icon = EnumsHeweatherCodeIcon.conversion(Integer.parseInt(jsonObj.getString("cond_code")));
			/** 温度 */
			hourlyVo.setTemp(Integer.parseInt(jsonObj.getString("tmp")));
			/** 图标 */
			hourlyVo.setIcon(day ? icon.dayIcon() : icon.nightIcon());
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
			icon = EnumsHeweatherCodeIcon.conversion(Integer.parseInt(jsonObj.getString("cond_code_d")));
			/** 温度 */
			dailyDetailVo.setTemp(Integer.parseInt(jsonObj.getString("tmp_max")));
			/** 图标 */
			dailyDetailVo.setIcon(icon.dayIcon());
			/** 天气 */
			dailyDetailVo.setWeather(jsonObj.getString("cond_txt_d"));
			dailyVo.setDay(dailyDetailVo);
			
			dailyDetailVo = new WeatherDailyDetailVo();
			/** 夜里 */
			icon = EnumsHeweatherCodeIcon.conversion(Integer.parseInt(jsonObj.getString("cond_code_n")));
			/** 温度 */
			dailyDetailVo.setTemp(Integer.parseInt(jsonObj.getString("tmp_min")));
			/** 图标 */
			dailyDetailVo.setIcon(icon.nightIcon());
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
			ls = EnumsHeweatherLifeStyle.conversion(jsonObj.getString("type"));
			/** 显示名称 */
			lifeVo.setName(ls.description());
			/** 图标 */
			lifeVo.setIcon(ls.icon());
			/** 内容 */
			lifeVo.setInfo(jsonObj.getString("brf"));
			/** 详情 */
			lifeVo.setDetail(jsonObj.getString("txt"));
			
			life.add(lifeVo);
		}
		
		weather.setLife(life);
		
		JSONObject airObj = sdk.s6Air(weatherObj.getJSONObject("basic").getString("parent_city"));
		
		if (airObj == null) return weather;
		
		/** ####当前空气质量#### */
		WeatherAirVo air = new WeatherAirVo();

		/** 显示名称 */
		air.setName(airObj.getJSONObject("air_now_city").getString("qlty"));
		/** 数值 */
		air.setNum(Integer.parseInt(airObj.getJSONObject("air_now_city").getString("aqi")));
		/** 颜色 */
		int aqi = Integer.parseInt(airObj.getJSONObject("air_now_city").getString("aqi"));
		if (aqi < 50)
			air.setColor("#00cf9a");
		else if (aqi < 100)
			air.setColor("#00cf9a");
		else if (aqi < 150)
			air.setColor("#00cf9a");
		else if (aqi < 200)
			air.setColor("#4295f4");
		else if (aqi < 300)
			air.setColor("#4295f4");
		else
			air.setColor("#ff6600");
		
		weather.setAir(air);
		
		return weather;
	}
}
