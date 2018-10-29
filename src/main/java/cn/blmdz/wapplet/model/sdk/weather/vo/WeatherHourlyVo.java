package cn.blmdz.wapplet.model.sdk.weather.vo;

import lombok.Data;

@Data
public class WeatherHourlyVo {
	/** 温度 */
	private Integer temp;
	/** 图标 */
	private String icon;
	/** 天气 */
	private String weather;
	/** 时间 */
	private String time;
}
