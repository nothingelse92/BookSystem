package com.news.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.news.po.Topic;

/**
 * 基本接口
 * @author 杨超民  2013-7-16  下午10:49:25
 *
 */
public interface BaseDaoI<T> {
	
	T  get(Class<T> clazz,String id);
	
	T  get(String hql);
	
	T  get(String hql,Map<String, Object> params);
	
	List<T> getAllList(Class clazz);
	
	List<T> find(String hql);
	
	List<T> find(String hql,Map<String,Object> params);
	
	List<T> find(String hql,int page,int rows);
	
	List<T> find(String hql,Map<String,Object> params,int page,int rows);
	
	int count(String hql);
	
	int count(String hql,Map<String,Object> params);
	
	Serializable save(T o);
	
	void update(T o);
	
	void updateCondition(String hql,Map<String,Object> params);
	
	void delete(T o);
	
	void deleteCondition(String hql,Map<String,Object> params);
	
	Query createQuery(String hql);
	
	Query queryparams(String hql,Map<String,Object> params);
	
	int insert(String sql);
	
	int select(String sql);
	
	int delete(String sql);
	
	int update(String sql);
	
}
