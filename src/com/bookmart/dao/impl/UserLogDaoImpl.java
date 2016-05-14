package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.UserLogDaoI;
/**
 * 用户数据实现类
 * @author 杨超民  2013-7-17  上午8:29:30
 *
 * @param <UserLog>
 */
@Repository("userLogDao")
public class UserLogDaoImpl<UserLog> extends BaseDaoImpl<UserLog>
			implements UserLogDaoI<UserLog> {

}
