package cn.blmdz.wapplet.enums;

public enum EnumsError {
    
    ERROR_000001(1, "不支持的RequestMethod参数类型"),
    ERROR_000002(2, "缺少必要RequestParam参数"),
    ERROR_000003(3, "不支持的MediaType类型"),
    ERROR_000004(4, "必要参数有误"),
    ERROR_000005(5, "未登录"),

    ERROR_000101(101, "用户信息解密异常"),
    ERROR_000102(102, "用户识别异常"),
    
    
	ERROR_000000(0, "success"),
    ERROR_999996(999996, "请求method暂不支持"),
    ERROR_999997(999997, "缺少必要参数"),
    ERROR_999998(999998, "数据为空"),
	ERROR_999999(999999, "系统异常"),

	;
    
    
    
    
    private int code;
    private String description;

    public int code() {
        return code;
    }
    public String description() {
        return description;
    }

	EnumsError(int code, String description) {
        this.code = code;
        this.description = description;
	}
}
