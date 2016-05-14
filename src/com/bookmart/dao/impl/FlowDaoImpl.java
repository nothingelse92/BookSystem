package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.FlowDaoI;
import com.news.dao.UserDaoI;

@Repository("flowDao")
public class FlowDaoImpl<User> extends BaseDaoImpl<User> 
		implements FlowDaoI<User> {

}
