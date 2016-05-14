package com.news.service;

import java.util.List;

import com.news.po.Books;

public interface BooksServiceI {

	List<Books> getHotBooks();
	
	List<Books> getFlowBooks();
	
	
	int like(int books_id);
	
	int wantBook(int user_id,int books_id);
	
	Books getBook(int books_id);
	
	List<String> getComment(int books_id);
	
	List<Books> getWantbook(int user_id);
}
