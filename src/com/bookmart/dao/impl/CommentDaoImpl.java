package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.CommentDaoI;
/**
 * 评论数据实现类
 * @author 杨超民  2013-7-17  上午8:23:46
 *
 * @param <Comments>
 */
@Repository("commentDao")
public class CommentDaoImpl<Comment> extends BaseDaoImpl<Comment> 
		implements CommentDaoI<Comment> {

}
