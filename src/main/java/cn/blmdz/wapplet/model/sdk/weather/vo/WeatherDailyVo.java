package cn.blmdz.wapplet.model.sdk.weather.vo;

import lombok.Data;

@Data
public class WeatherDailyVo {
	/** 白天 */
	private WeatherDailyDetailVo day;
	/** 夜里 */
	private WeatherDailyDetailVo night;
	/** 风向 */
	private String wind;
	/** 风力等级 */
	private String windLevel;
	/** 时间 */
	private String time;
}
