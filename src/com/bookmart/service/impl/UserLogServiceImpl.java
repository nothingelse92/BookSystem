package com.news.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.dao.UserLogDaoI;
import com.news.po.UserLog;
import com.news.service.UserLogServiceI;

@Service("userLogService")
public class UserLogServiceImpl implements UserLogServiceI {

	@Autowired
	private UserLogDaoI<UserLog> userLogDao;

	/**
	 * 获取某用户所有登录日志
	 *//*
	@SuppressWarnings("unchecked")
	@Override
	public List<UserLog> getAllList(int id) {
		final String hql = "from UserLog l where l.user.id = :id";
		Map map = new HashMap<String, Object>();
		map.put("id", id);
		List<UserLog> list = userLogDao.find(hql, map);
		if (null != list && list.size() > 0)
			return list;
		return null;
	}
*/
	@Override
	public Serializable save(UserLog log) {
		return userLogDao.save(log);
	}

	@Override
	public void update(UserLog log) {
		userLogDao.update(log);
	}

}
