package com.news.controller;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.po.Books;
import com.news.po.User;
import com.news.service.BooksServiceI;
import com.news.service.UserLogServiceI;
import com.news.service.UserServiceI;
import com.news.util.JSONUtil;

@Controller
public class BooksController {

	@Autowired
	private BooksServiceI booksService;
	

	@RequestMapping(value = "/getHotBooks.do")
	public void getHotBooks(HttpServletRequest request, HttpServletResponse response) {
		
		List<Books> lb=booksService.getHotBooks();
		try {
			JSONUtil.outString(response, JSONUtil.toJSONString(lb));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value = "/getFlowBooks.do")
	public void getFlowBooks(HttpServletRequest request, HttpServletResponse response) {
		List<Books> lb=booksService.getFlowBooks();
		try {
			JSONUtil.outString(response, JSONUtil.toJSONString(lb));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/like.do")
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int books_id = Integer.parseInt(request.getParameter("books_id"));
		booksService.like(books_id);
		JSONUtil.outString(response, "success");
	}
	
	
	
	@RequestMapping(value = "/getComment.do")
	public void getComment(HttpServletRequest request, HttpServletResponse response) {
		int books_id = Integer.parseInt(request.getParameter("books_id"));
		List<String> ls=booksService.getComment(books_id);
		try {
			JSONUtil.outString(response, JSONUtil.toJSONString(ls));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/getBook.do")
	public void getBook(HttpServletRequest request, HttpServletResponse response) {
		int books_id = Integer.parseInt(request.getParameter("books_id"));
		Books b=booksService.getBook(books_id);
		try {
			JSONUtil.outString(response, JSONUtil.toJSONString(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@RequestMapping(value = "/getWantBook.do")
	public void getWantBook(HttpServletRequest request, HttpServletResponse response) {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		List<Books> lb=booksService.getWantbook(user_id);
		try {
			JSONUtil.outString(response, JSONUtil.toJSONString(lb));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/test.do")
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONUtil.outString(response, "test!!!!!!");
	}
	
	

}
