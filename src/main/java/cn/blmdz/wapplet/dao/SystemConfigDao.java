package cn.blmdz.wapplet.dao;

import org.apache.ibatis.annotations.Param;

import cn.blmdz.wapplet.model.entity.SystemConfig;

public interface SystemConfigDao extends BaseDao<SystemConfig> {
	
	/**
	 * 根据类型查找
	 * @param type
	 * @return
	 */
	SystemConfig findByType(@Param("type") Integer type);
}