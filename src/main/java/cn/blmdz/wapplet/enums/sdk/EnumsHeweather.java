package cn.blmdz.wapplet.enums.sdk;

public enum EnumsHeweather {

    OK("ok", "成功"), 
    ANR("anr", "服务器内部错误"), 
    DEAD("dead", "服务器内部错误"), 
    VIP_OVER("vip over", "用户服务已过期"), 
    INVALID_KEY("invalid key", "无效的KEY"), 
    UNKNOWN_LOCATION("unknown location", "未知的城市"), 
    UNKNOWN_CITY("unknown city", "未知的城市"), 
    NO_MORE_REQUESTS("no more requests", "用户的访问量已耗尽"), 
    PERMISSION_DENIED("permission denied", "无访问权限"), 
    PARAM_INVALID("param invalid", "请求参数错误或缺失"), 
    TOO_FAST("too fast", "访问频率太快"), 
    NO_DATA("no data for this location", "该城市/地区没有你所请求的数据"), 
    SDK_UNKNOWN_ERROR("sdk unknown error", "SDK 未知错误"), 
    INTERNET_EXCEPTION("internet error", "网络异常, 数据获取失败, 请检查域名或网络状况"), 
    SIGN_ERROR("sign error", "签名错误"), 
    EXCEEDS_LIMIT("exceeds limit", "超出授权上限"), 
    UNKNOWN_CODE("unknown code", "未知的错误代码"), 
    INTERNET("internet error", "网络异常"), 
    EXPIRE("expired", "授权已过期");
    ;
    
	private final String code;
	private final String description;
	
    public final String code() {
        return code;
    }
    public final String description() {
    	return description;
    }
	
	EnumsHeweather(String code, String description) {
		this.code = code;
		this.description = description;
	}
}
