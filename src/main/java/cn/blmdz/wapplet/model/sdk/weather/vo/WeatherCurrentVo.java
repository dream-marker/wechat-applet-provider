package cn.blmdz.wapplet.model.sdk.weather.vo;

import lombok.Data;

@Data
public class WeatherCurrentVo {
	/** 背景图 */
	private String bgImg;
	/** 背景色 */
	private String bgColor;
	/** 温度 */
	private Integer temp;
	/** 湿度 */
	private Integer humidity;
	/** 图标 */
	private String icon;
	/** 天气 */
	private String weather;
	/** 风向 */
	private String wind;
	/** 风力等级 */
	private String windLevel;
	/** 天气更新时间 */
	private String updateTime;
}
