package com.news.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.news.dao.BaseDaoI;

/**
 * 基本方法实现
 * 
 * @author 杨超民 2013-7-16 下午11:05:37
 * 
 * @param <T>
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> clazz, String id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String hql) {
		List<T> l = createQuery(hql).list();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = queryparams(hql, params);
		List<T> l = q.list();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		return createQuery(hql).list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = queryparams(hql, params);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = createQuery(hql);
		return q.setFirstResult((page -1)* rows).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = queryparams(hql, params);
		return q.setFirstResult((page -1)* rows).setMaxResults(rows).list();
	}

	@Override
	public int count(String hql) {
		Query q =  createQuery(hql);
		return ((Long)q.uniqueResult()).intValue();
	}

	@Override
	public int count(String hql, Map<String, Object> params) {
		Query q = queryparams(hql, params);
		return ((Long)q.uniqueResult()).intValue();
	}

	@Override
	public Serializable save(T o) {
		return getSession().save(o);
	}

	@Override
	public void update(T o) {
		getSession().update(o);
	}

	@Override
	public void delete(T o) {
		getSession().delete(o);
	}

	
	@Override
	public void updateCondition(String hql, Map<String, Object> params) {
		Query q = queryparams(hql, params);
		q.executeUpdate();
	}

	@Override
	public void deleteCondition(String hql, Map<String, Object> params) {
		Query q = queryparams(hql, params);
		q.executeUpdate();
	}
	
	
	
	
	@Override
	public Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}

	@Override
	public Query queryparams(String hql, Map<String, Object> params) {
		Query q = createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet())
				q.setParameter(key, params.get(key));
		}
		return q;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllList(Class clazz) {
		return getSession().createCriteria(clazz).list();
	}

	@Override
	public int insert(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
		return 0;
	}

	@Override
	public int select(String sql) {
		
		return 0;
	}

	@Override
	public int delete(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
		return 0;
	}

	@Override
	public int update(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
		return 0;
	}



	
}
