package com.news.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.news.po.Comments;

/**
 * 评论接口
 */
public interface CommentServiceI {
	
	Serializable save(Comments comment);

	List<Comments> getpageList(String hql,Map<String,Object> params,int page,int rows);
}
