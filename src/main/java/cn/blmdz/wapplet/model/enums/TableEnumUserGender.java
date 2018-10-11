package cn.blmdz.wapplet.model.enums;

import com.google.common.base.Objects;

/**
 * @author xpoll
 */
public enum TableEnumUserGender {


    UNKNOWN(-1, "未设置"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    
    ;

    private final int code;
    private final String description;

    public int code() {
        return this.code;
    }


    public String description() {
        return description;
    }

    private TableEnumUserGender(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TableEnumUserGender conversion(int code) {
        for (TableEnumUserGender item : TableEnumUserGender.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
}
