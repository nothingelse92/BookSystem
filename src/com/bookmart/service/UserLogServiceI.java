package com.news.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.news.po.UserLog;

/**
 * 登录日志接口
 * @author 杨超民  2013-7-17  上午8:36:13
 *
 */
public interface UserLogServiceI {
	
	
	
	Serializable save(UserLog log);
	
	void update(UserLog log);
}
