package cn.blmdz.wapplet.model.enums;

import com.google.common.base.Objects;

public enum TableEnumStatusUser {
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
	
    TableEnumStatusUser(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static TableEnumStatusUser conversion(int code) {
		for (TableEnumStatusUser item : TableEnumStatusUser.values()) {
			if (Objects.equal(item.code, code)) return item;
		}
		return null;
	}
}
