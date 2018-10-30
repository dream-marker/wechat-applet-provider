package cn.blmdz.wapplet.model.sdk.weather.enums;

import com.google.common.base.Objects;

/**
 * 生活指数类型 
 * 
 * @author xpoll
 */
public enum EnumsHeweatherLifeStyle {

	LS_1("comf", "", "舒适度"),
	LS_2("cw", "", "洗车"),
	LS_3("drsg", "", "穿衣"),
	LS_4("flu", "", "感冒"),
	LS_5("sport", "", "运动"),
	LS_6("trav", "", "旅游"),
	LS_7("uv", "", "紫外线"),
	LS_8("air", "", "空气污染扩散条件"),
	LS_9("ac", "", "空调开启"),
	LS_10("ag", "", "过敏"),
	LS_11("gl", "", "太阳镜"),
	LS_12("mu", "", "化妆"),
	LS_13("airc", "", "晾晒"),
	LS_14("ptfc", "", "交通"),
	LS_15("fsh", "", "钓鱼"),
	LS_16("spi", "", "防晒"),
    ;

	private final String code;
	private final String icon;
	private final String description;

    public final String code() {
        return code;
    }
    public final String icon() {
        return icon;
    }
    public final String description() {
    	return description;
    }
	
	EnumsHeweatherLifeStyle(String code, String icon, String description) {
		this.code = code;
		this.icon = icon;
		this.description = description;
	}

    public static EnumsHeweatherLifeStyle conversion(String code) {
        for (EnumsHeweatherLifeStyle item : EnumsHeweatherLifeStyle.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
}
