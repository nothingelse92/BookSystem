package com.news.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.dao.UserDaoI;
import com.news.po.User;
import com.news.service.UserServiceI;
import com.news.util.EncryptUtil;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserDaoI<User> userDao;

	/**
	 * 新增
	 */
	@Override
	public Serializable save(User u) {
		return userDao.save(u);
	}

	/**
	 * 登录
	 */
	@Override
	public User login(User u) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", u.getName());
		try {
			//map.put("pwd", EncryptUtil.addMD5(u.getPassword()));
			//暂时不用MD5
			map.put("password", u.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//final String hql = "select * from user where name = '"+u.getName()+"' and password = '"+u.getPassword()+"'";
		final String hql = "from User u where u.name = '"+u.getName()+"' and u.password = '"+u.getPassword()+"'";
		User user = userDao.get(hql);
		if (null != user)
			return user;
		return null;
	}

	/**
	 * 判断用户名是否被占用
	 */
	@Override
	public boolean exist(String username) {
		final String hql = "from User u where u.name = :name";
		List list = userDao.createQuery("hql").setParameter("name", username).list();
		if (null != list && list.size() > 0)
			return true;
		return false;
	}

	/**
	 * 修改
	 */
	@Override
	public void update(User u) {
		userDao.update(u);
	}

	@Override
	public int register(User u) {
		
		//userDao.save(u);
		final String sql = "insert into user (name,password,email,phone) values ('"+u.getName()+"','"+u.getPassword()+"','"+u.getEmail()+"','"+u.getPhone()+"') ";
		System.out.println(sql);
		userDao.insert(sql);
		return 0;
	}

}
