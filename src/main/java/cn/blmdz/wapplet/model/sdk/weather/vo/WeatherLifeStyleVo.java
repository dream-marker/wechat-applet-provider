package cn.blmdz.wapplet.model.sdk.weather.vo;

import lombok.Data;

@Data
public class WeatherLifeStyleVo {
	/** 显示名称 */
	private String name;
	/** 图标 */
	private String icon;
	/** 内容 */
	private String info;
	/** 详情 */
	private String detail;
}
