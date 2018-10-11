package cn.blmdz.wapplet.model.applet;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class WechatAppletUserInfoResponse extends WechatBaseResponse {

    private String openId;
    private String unionId;
    private String nickName;
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    
}
