package cn.blmdz.wapplet.model.enums;

import com.google.common.base.Objects;

/**
 * @author xpoll
 */
public enum TableEnumUserThirdChannel {
    


    WECHAT_APPLET_COMMUNITY(1, true, Type.COMMUNITY, "微信-小程序-社区"),
    
    ;

    private final int code;
    private final boolean show;
    private final Type type;
    private final String description;

    public int code() {
        return this.code;
    }
    public boolean show() {
        return this.show;
    }
    public Type type() {
        return this.type;
    }
    public String description() {
        return description;
    }

    private TableEnumUserThirdChannel(int code, boolean show, Type type, String description) {
        this.code = code;
        this.show = show;
        this.type = type;
        this.description = description;
    }

    public static TableEnumUserThirdChannel conversion(int code) {
        for (TableEnumUserThirdChannel item : TableEnumUserThirdChannel.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
    
    public enum Type {
        APP(1, "应用"),
        GAME(2, "游戏"),
        COMMUNITY(3, "社区"),
        ;

        private final int code;
        private final String description;

        public int code() {
            return this.code;
        }
        public String description() {
            return description;
        }

        private Type(int code, String description) {
            this.code = code;
            this.description = description;
        }
        
        public static Type conversion(int code) {
            for (Type item : Type.values()) {
                if (Objects.equal(item.code, code)) return item;
            }
            return null;
        }
    }
}
