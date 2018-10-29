package cn.blmdz.wapplet.model.sdk.weather.vo;

import lombok.Data;

@Data
public class WeatherDailyDetailVo {
	/** 温度 */
	private Integer temp;
	/** 图标 */
	private String icon;
	/** 天气 */
	private String weather;
}
