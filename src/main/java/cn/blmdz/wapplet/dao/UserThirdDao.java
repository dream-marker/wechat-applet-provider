package cn.blmdz.wapplet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.blmdz.wapplet.model.entity.UserThird;

public interface UserThirdDao extends BaseDao<UserThird> {
    
    /**
     * 根据账户1查找
     */
    List<UserThird> findByAccount_1(@Param("account_1") String account_1);

    /**
     * 根据账户2查找
     */
    UserThird findByAccount_2(@Param("account_2") String account_2);
    
    /**
     * 根据用户ID查找
     */
    List<UserThird> findByUserId(@Param("userId") Long userId);
}