package com.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.dao.BooksDaoI;
import com.news.dao.CommentDaoI;
import com.news.dao.FlowDaoI;
import com.news.dao.HotDaoI;
import com.news.dao.UserDaoI;
import com.news.po.Books;
import com.news.po.Comment;
import com.news.po.Flow;
import com.news.po.Hot;
import com.news.po.User;
import com.news.service.BooksServiceI;
import com.news.service.UserServiceI;

@Service("booksService")
public class BooksServiceImpl implements BooksServiceI {

	@Autowired
	private BooksDaoI<Books> booksDao;

	@Autowired
	private CommentDaoI<Comment> commentDao;

	
	@Autowired
	private HotDaoI<Hot> hotDao;

	@Autowired
	private FlowDaoI<Flow> flowDao;

	
	public List<Books> getHotBooks(){
		final String hql = "from Books b order by b.hot desc limit 0,8";
		List<Books> books = booksDao.find(hql);
		return books;
	}


	@Override
	public List<Books> getFlowBooks() {
		final String hql = "from Books b order by upload_time desc limit 0,8";
		List<Books> books = booksDao.find(hql);
		return books;
	}


	

	@Override
	public Books getBook(int books_id) {
		final String hql = "from Books b where b.id="+books_id;
		Books book = booksDao.get(hql);
		return book;
	}


	@Override
	public List<String> getComment(int books_id) {
		final String hql = "from Comment c where c.books_id="+books_id;
		List<Comment> c = commentDao.find(hql);
		ArrayList<String> comments=new ArrayList();
		for(int i=0;i<c.size();i++){
			comments.add(c.get(i).getComment());			
		}
		return comments;
	}


	@Override
	public int like(int books_id) {
		Books b=getBook(books_id);
		final String sql = "update books set hot="+(b.getHot()+1)+" where id="+books_id;
		booksDao.update(sql);
		return 0;
	}


	@Override
	public int wantBook(int user_id,int books_id) {
		Books b=getBook(books_id);
		final String sql = "insert into flow (user_id,books_id) values ("+user_id+","+books_id+")";

		flowDao.insert(sql);
		return 0;
	}


	@Override
	public List<Books> getWantbook(int user_id) {
		final String hql = "from Flow f where f.user_id="+user_id;
		List<Flow> lf = flowDao.find(hql);
		
		ArrayList<Books> books=new ArrayList();
		for(int i=0;i<lf.size();i++){
			books.add(getBook(lf.get(i).getBooks_id()));			
		}
		
		return books;
	}
	
	
	
}
