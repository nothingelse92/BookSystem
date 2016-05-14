package com.news.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.news.po.News;

/**
 * 新闻接口
 * @author 杨超民  2013-7-17  上午8:52:26
 *
 */
public interface NewsServiceI {
	
	Serializable save(News n);
	
	void update(News n);
	
	News get(String id);
	
	int count(String tid);
	
	List<News> getList(String tid);
	
	List<News> getNewsList(String hql,Map<String,Object> map);
	
	List<News> getNewsList(String hql,Map<String,Object> map, int page,int rows);
}
