package cn.blmdz.wapplet.model.sdk.weather.enums;

import com.google.common.base.Objects;

/**
 * @author xpoll
 */
public enum EnumsHeweatherScenes {

	DEFAULT(0, "无场景")
    ;

	private final Integer code;
	private final String description;

    public final Integer code() {
        return code;
    }
    public final String description() {
    	return description;
    }
	
	EnumsHeweatherScenes(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

    public static EnumsHeweatherScenes conversion(int code) {
        for (EnumsHeweatherScenes item : EnumsHeweatherScenes.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
}
