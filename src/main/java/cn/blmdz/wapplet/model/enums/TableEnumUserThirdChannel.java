package cn.blmdz.wapplet.model.enums;

import com.google.common.base.Objects;

/**
 * 枚举 - 第三方用户绑定表
 * @channel 渠道
 * @author xpoll
 */
public enum TableEnumUserThirdChannel {


    WECHAT_APPLET_1(1, "微信-小程序-1"),// 微信小程序
    
    ;

    private final int code;
    private final String description;

    public int code() {
        return this.code;
    }


    public String description() {
        return description;
    }

    private TableEnumUserThirdChannel(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TableEnumUserThirdChannel conversion(int code) {
        for (TableEnumUserThirdChannel item : TableEnumUserThirdChannel.values()) {
            if (Objects.equal(item.code, code)) return item;
        }
        return null;
    }
}
