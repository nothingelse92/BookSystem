package com.news.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.dao.NewsDaoI;
import com.news.po.News;
import com.news.service.NewsServiceI;
/**
 * 新闻接口
 * @author 杨超民  2013-7-17  上午11:44:38
 *
 */
@Service("newService")
public class NewsServiceImpl implements NewsServiceI {

	@Autowired
	private NewsDaoI<News> newsDao;
	
	@Override
	public Serializable save(News n) {
		return newsDao.save(n);
	}

	@Override
	public void update(News n) {
		newsDao.update(n);
	}

	@Override
	public News get(String id) {
		return newsDao.get(News.class, id);
	}

	@Override
	public List<News> getNewsList(String hql, Map<String, Object> map) {
		return newsDao.find(hql, map);
	}

	@Override
	public List<News> getNewsList(String hql, Map<String, Object> map, int page, int rows) {
		return newsDao.find(hql, map, page, rows);
	}

	@Override
	public List<News> getList(String tid) {
		String hql = "from News n where n.topic.id = '"+tid+"'";
		return newsDao.find(hql);
	}

	@Override
	public int count(String tid) {
		return newsDao.count("select count(*) from News n where n.topic.id = '"+tid+"'");
	}

}
