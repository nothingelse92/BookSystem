package com.news.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hot")
public class Hot extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int user_id;
	
	@Id
	private int books_id;
	
	@Column
	private String description;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBooks_id() {
		return books_id;
	}

	public void setBooks_id(int books_id) {
		this.books_id = books_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
