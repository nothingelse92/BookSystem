package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.UserDaoI;
/**
 * 用户数据实现类
 * @author 杨超民  2013-7-17  上午8:27:02
 *
 * @param <User>
 */
@Repository("userDao")
public class UserDaoImpl<User> extends BaseDaoImpl<User> 
		implements UserDaoI<User> {

}
