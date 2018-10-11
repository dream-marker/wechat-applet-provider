package cn.blmdz.wapplet.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主键ID */
    private Long id;
    /** 昵称 */
    private String nick;
    /** 头像 */
    private String avatar;
    /** 性别 */
    private Integer gender;
    /** 生日 */
    private Date birthday;
    /** 区域 */
    private Integer area;
    /** 注册渠道-TableEnumChannelUserThird */
    private Integer channel;
    /** 系统状态 */
    private Integer status;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
