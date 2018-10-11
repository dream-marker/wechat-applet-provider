package cn.blmdz.wapplet.model.enums;

import com.google.common.base.Objects;

public enum TableEnumUserStatus {
    NORMAL(1, "正常"),
    FREEZE(2, "冻结"),
    ;
	
	private final int code;
	private final String description;

    public final int code() {
        return code;
    }

    public final String description() {
        return description;
    }
	
    TableEnumUserStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static TableEnumUserStatus conversion(int code) {
		for (TableEnumUserStatus item : TableEnumUserStatus.values()) {
			if (Objects.equal(item.code, code)) return item;
		}
		return null;
	}
}
