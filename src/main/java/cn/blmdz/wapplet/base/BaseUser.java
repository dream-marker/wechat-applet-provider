package cn.blmdz.wapplet.base;

import cn.blmdz.wapplet.model.enums.TableEnumChannelUserThird;
import lombok.Data;

@Data
public class BaseUser {

    /** 用户ID */
    private Long userId;
    /** 第三方用户绑定ID */
    private Long thirdId;
    /** 昵称 */
    private String nick;
    /** 头像 */
    private String avatar;
    /** 性别 */
    private Integer gender;
    /** 用户账号1 */
    private String account_1;
    /** 用户账号2 */
    private String account_2;
    /** 渠道 */
    private TableEnumChannelUserThird channel;
}
