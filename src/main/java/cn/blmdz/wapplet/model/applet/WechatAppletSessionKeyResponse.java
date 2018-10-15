package cn.blmdz.wapplet.model.applet;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class WechatAppletSessionKeyResponse extends WechatBaseResponse {
    private String session_key;
    private Integer expires_in;
    private String openid;
    private String unionid;
}
