package cn.blmdz.wapplet.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 第三方用户绑定表
 */
@Data
public class UserThird implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主键ID */
    private Long id;
    /** 用户ID */
    private Long userId;
    /** 账号-1 */
    private String account_1;
    /** 账号-2 */
    private String account_2;
    /** 昵称 */
    private String nick;
    /** 头像 */
    private String avatar;
    /** 渠道 */
    private Integer channel;
    /** 创建时间 */
    private Date createTime;
}
