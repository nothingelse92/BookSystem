package com.news.controller.model;

import java.util.ArrayList;
import java.util.List;

import com.news.po.News;
import com.news.po.Topic;
import com.news.util.PageUtil;

public class NewsModel {
	
	private List<News> leftInLandList = new ArrayList<News>();
	private List<News> leftForeignList = new ArrayList<News>();
	private List<News> leftFunList = new ArrayList<News>();
	private List<Topic> topicList = new ArrayList<Topic>();
	private List<News> newsList = new ArrayList<News>();
	private PageUtil pageUtil = new PageUtil();
	private String topicID;
	
	
	public String getTopicID() {
		return topicID;
	}

	public void setTopicID(String topicID) {
		this.topicID = topicID;
	}

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public List<News> getLeftInLandList() {
		return leftInLandList;
	}

	public void setLeftInLandList(List<News> leftInLandList) {
		this.leftInLandList = leftInLandList;
	}

	public List<News> getLeftForeignList() {
		return leftForeignList;
	}

	public void setLeftForeignList(List<News> leftForeignList) {
		this.leftForeignList = leftForeignList;
	}

	public List<News> getLeftFunList() {
		return leftFunList;
	}

	public void setLeftFunList(List<News> leftFunList) {
		this.leftFunList = leftFunList;
	}

	

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	
	
	
}
