package cn.blmdz.wapplet.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 系统配置表
 */
@Data
public class SystemConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ID */
    private Long id;
    /** 类型 */
    private Integer type;
    /** 内容 */
    private String config;
    /** 创建人ID */
    private Long createUser;
    /** 更新人ID */
    private Long updateUser;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
