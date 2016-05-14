package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.BooksDaoI;
import com.news.dao.UserDaoI;

@Repository("booksDao")
public class BooksDaoImpl<User> extends BaseDaoImpl<User> 
		implements BooksDaoI<User> {

}
