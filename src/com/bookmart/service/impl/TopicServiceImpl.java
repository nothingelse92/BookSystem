package com.news.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.dao.TopicDaoI;
import com.news.po.Topic;
import com.news.service.TopicServiceI;
@Service("topicService")
public class TopicServiceImpl implements TopicServiceI {

	@Autowired
	private TopicDaoI<Topic> topicDao;
	
	@Override
	public Serializable save(Topic t) {
		return topicDao.save(t);
	}

	@Override
	public List<Topic> getAllList() {
		return topicDao.getAllList(Topic.class);
	}

}
