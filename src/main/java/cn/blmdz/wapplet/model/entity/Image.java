package cn.blmdz.wapplet.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 图片表
 */
@Data
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主键ID */
    private Long id;
    
    /** 图片地址 */
    private String img;
    
    /** 创建时间 */
    private Date createTime;
}
