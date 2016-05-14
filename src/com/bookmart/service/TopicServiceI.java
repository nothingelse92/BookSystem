package com.news.service;

import java.io.Serializable;
import java.util.List;

import com.news.po.Topic;

/**
 * 主题接口
 * @author 杨超民  2013-7-17  上午8:41:57
 *
 */
public interface TopicServiceI {

	
	Serializable save(Topic t);
	
	List<Topic> getAllList();
}
