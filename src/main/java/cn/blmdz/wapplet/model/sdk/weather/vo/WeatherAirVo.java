package cn.blmdz.wapplet.model.sdk.weather.vo;

import lombok.Data;

@Data
public class WeatherAirVo {
	/** 显示名称 */
	private String name;
	/** 数值 */
	private Integer num;
	/** 颜色 */
	private String color;
}
