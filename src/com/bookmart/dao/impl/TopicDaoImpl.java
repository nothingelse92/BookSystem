package com.news.dao.impl;

import org.springframework.stereotype.Repository;

import com.news.dao.TopicDaoI;
/**
 * 主题数据实现类
 * @author 杨超民  2013-7-17  上午8:25:18
 *
 * @param <Topic>
 */
@Repository("topicDao")
public class TopicDaoImpl<Topic> extends BaseDaoImpl<Topic> 
			implements TopicDaoI<Topic>{

}
