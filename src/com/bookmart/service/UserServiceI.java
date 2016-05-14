package com.news.service;

import java.io.Serializable;

import com.news.po.User;

/**
 * 用户接口
 * @author 杨超民  2013-7-17  上午8:31:50
 *
 */
public interface UserServiceI {
	
	Serializable save(User u);
	
	User login(User u);
	
	int register(User u);
	
	/**
	 * 检查用户名是否存在
	 */
	boolean exist(String username);
	
	/**
	 * 修改
	 * @param u
	 */
	void update(User u); 
}
