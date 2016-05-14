package com.news.controller;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.news.controller.model.NewsModel;
import com.news.po.Comments;
import com.news.po.Topic;
import com.news.service.CommentServiceI;
import com.news.service.NewsServiceI;
import com.news.service.TopicServiceI;
import com.news.util.PageUtil;

/**
 * 新闻控制器
 * 
 * @author 杨超民 2013-7-23 上午10:15:29
 * 
 */
@Controller
public class NewsController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NewsController.class);

	@Autowired
	private NewsServiceI newService;

	@Autowired
	private TopicServiceI topicService;
	
	@Autowired
	private CommentServiceI commentService;

	/**
	 * 获取国内
	 */
	public void getLeftInLand(NewsModel newsModel) {
		newsModel.setLeftInLandList(newService.getList(Topic.INLAND));
		newsModel.setLeftForeignList(newService.getList(Topic.FOREIGN));
		newsModel.setLeftFunList(newService.getList(Topic.FUN));
		newsModel.setTopicList(topicService.getAllList());
	}

	/**
	 * 获取国外
	 */
	public void getLeftForeign() {
	}

	/**
	 * 娱乐
	 */
	public void getLeftFun() {

	}

	// @RequestMapping("/test.html")
	public String test() {
		return "check";
	}

	/**
	 * 获取所有
	 */
	@RequestMapping(value = "/index.html")
	public ModelAndView getNewsList(NewsModel model) {
		getLeftInLand(model);
		model.setNewsList(newService.getNewsList("from News", null));
		return new ModelAndView("index", "model", model);
	}

	/**
	 * 根据条件获取
	 */
	@RequestMapping(value = "/paramIndex.html")
	public ModelAndView getParamList(String topicID, String pageindex, NewsModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from News n ";
		int total = 0;
		if (topicID != null) {
			hql += " where n.topic.id = :id";
			map.put("id", topicID);
			total = newService.count(topicID);
		} else
			total = newService.getNewsList(hql, null).size();
		int currentPage = 1;
		if (pageindex != null) {
			currentPage = Integer.parseInt(pageindex);
		}
		PageUtil page = new PageUtil(5, total, currentPage);
		page.setPageRecord(5);
		page.setTotalRecord(total);
		page.setPageNumStart(page.getPageNumStart());
		page.setPageNumEnd(page.getPageNumEnd());
		page.setCurrentPage(currentPage);

		getLeftInLand(model);
		model.setTopicID(topicID);
		model.setPageUtil(page);
		model.setNewsList(newService.getNewsList(hql, map, page.getCurrentPage(),
				page.getPageRecord()));
		return new ModelAndView("index", "model", model);
	}

	/**
	 * 获取新闻详情
	 * 
	 * @param newID
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail.html")
	public ModelAndView getDetail(String newId, Model model) {
		logger.info(newId);
		return new ModelAndView("news_read","news",newService.get(newId));
	}
	
	/**
	 * 保存评论
	 */
	@RequestMapping(value = "saveComment.html")
	public String saveComment(String newId,String name,String ip,String content){
		logger.info(name + "------" + content);
		Comments comments = new Comments();
		comments.setComAuthor(name);
		comments.setComContent(content);
		comments.setComIp(ip);
		comments.setComDate(new Date());
		comments.setNews(newService.get(newId));
		commentService.save(comments);
		return "redirect:detail.html?newId="+newId;
	}
}
