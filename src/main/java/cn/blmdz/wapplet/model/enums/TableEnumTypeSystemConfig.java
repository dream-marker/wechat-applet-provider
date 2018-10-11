package cn.blmdz.wapplet.model.enums;

/**
 * 枚举 - 管理员用户表
 * @type 类型
 * @author xpoll
 */
public enum TableEnumTypeSystemConfig {
	
    WECHAT_APPLET_1(10001, "微信小程序"),// TableEnumChannelUserThird 前面加1000
    ;
    
	
	private final int code;
	private final String description;
	
    public final int code() {
        return code;
    }
    public final String description() {
    	return description;
    }
	
	TableEnumTypeSystemConfig(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static TableEnumTypeSystemConfig conversion(int code) {
		for (TableEnumTypeSystemConfig type : TableEnumTypeSystemConfig.values()) {
			if (type.code == code)
				return type;
		}
		return null;
	}
}
