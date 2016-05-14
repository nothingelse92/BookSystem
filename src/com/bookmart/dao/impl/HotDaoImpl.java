package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.HotDaoI;
import com.news.dao.UserDaoI;

@Repository("hotDao")
public class HotDaoImpl<User> extends BaseDaoImpl<User> 
		implements HotDaoI<User> {

}
