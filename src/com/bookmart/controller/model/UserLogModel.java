package com.news.controller.model;

import java.util.ArrayList;
import java.util.List;

import com.news.po.UserLog;

/**
 * 登录日志
 * @author 杨超民  2013-7-19  上午11:33:05
 *
 */
public class UserLogModel {
	
	
	private List<UserLog> log = new ArrayList<UserLog>();

	public List<UserLog> getLog() {
		return log;
	}

	public void setLog(List<UserLog> log) {
		this.log = log;
	}
	
	
}
