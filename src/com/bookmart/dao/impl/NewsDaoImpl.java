package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.NewsDaoI;
/**
 * 新闻数据实现类
 * @author 杨超民  2013-7-17  上午8:20:42
 *
 * @param <News>
 */
@Repository("newsDao")
public class NewsDaoImpl<News> extends BaseDaoImpl<News> 
		implements NewsDaoI<News>{

}
