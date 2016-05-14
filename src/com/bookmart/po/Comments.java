package com.news.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 评论实体
 * @author YangChaoMin
 *	2013-7-15 上午10:49:36
 */
@Entity
@Table(name="comments")
public class Comments extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid.hex")
	private String comId;
	
	@ManyToOne
	@JoinColumn(name="nid")
	private News news;
	
	@Column
	private String comContent;
	
	@Column
	private Date comDate;
	
	@Column
	private String comIp;
	
	@Column
	private String comAuthor;
	
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}

	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public String getComIp() {
		return comIp;
	}
	public void setComIp(String comIp) {
		this.comIp = comIp;
	}
	public String getComAuthor() {
		return comAuthor;
	}
	public void setComAuthor(String comAuthor) {
		this.comAuthor = comAuthor;
	}
	
	

}
