package com.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.service.TopicServiceI;

/**
 * 主题控制器
 * 
 * @author 杨超民 2013-7-24 下午4:51:46
 * 
 */
@Controller
public class TopicController {

	@Autowired
	private TopicServiceI topicService;

	@RequestMapping(value = "/topiclist.html")
	public String getTopicList(Model model) {

		model.addAttribute("topiclist", topicService.getAllList());
		return "topic_list";
	}
}
