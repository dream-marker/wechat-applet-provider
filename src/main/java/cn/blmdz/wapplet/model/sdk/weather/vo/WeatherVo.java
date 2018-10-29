package cn.blmdz.wapplet.model.sdk.weather.vo;

import java.util.List;

import lombok.Data;

@Data
public class WeatherVo {

	/** 当天天气 */
	private WeatherCurrentVo current;
	/** 当前空气质量 */
	private WeatherAirVo air;
	/** 逐时预报 */
	private List<WeatherHourlyVo> hourly;
	/** 3-10天预报 */
	private List<WeatherDailyVo> daily;
	/** 生活指数 */
	private List<WeatherLifeStyleVo> life;
}
