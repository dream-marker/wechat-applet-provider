package cn.blmdz.wapplet.model.enums;

/**
 * 枚举 - 管理员用户表
 * @type 类型
 * @author xpoll
 */
public enum TableEnumSystemConfigType {

    WECHAT_APPLET_1(101, "微信小程序"),// TableEnumChannelUserThird 前面加10
    WECHAT_GANME_2(102, "微信小游戏"),// TableEnumChannelUserThird 前面加10
    
    HE_WEATHER(1, "和风天气")
    ;
    
	
	private final int code;
	private final String description;
	
    public final int code() {
        return code;
    }
    public final String description() {
    	return description;
    }
	
	TableEnumSystemConfigType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static TableEnumSystemConfigType conversion(int code) {
		for (TableEnumSystemConfigType type : TableEnumSystemConfigType.values()) {
			if (type.code == code)
				return type;
		}
		return null;
	}
}
