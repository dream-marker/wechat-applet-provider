package cn.blmdz.wapplet.dao;

import java.util.List;

import com.github.pagehelper.Page;

public interface BaseDao<T> {
	
	int create(T record);
	
	int delete(Long id);
	
    int update(T record);
    
    T findById(Long id);
    
    List<T> list();
    
    Page<T> page();
    
}