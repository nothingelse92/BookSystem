package com.news.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.dao.CommentDaoI;
import com.news.po.Comments;
import com.news.service.CommentServiceI;
@Service("commentService")
public class CommentServiceImpl implements CommentServiceI {

	@Autowired
	private CommentDaoI<Comments> commentDao;
	
	@Override
	public Serializable save(Comments comment) {
		return commentDao.save(comment);
	}

	@Override
	public List<Comments> getpageList(String hql, Map<String, Object> params, int page, int rows) {
		return commentDao.find(hql, params, page, rows);
	}

}
