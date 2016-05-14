package com.news.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 新闻实体
 * @author YangChaoMin
 *	2013-7-15 上午10:46:30
 */
@Entity
@Table(name="news")
public class News extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid.hex")
	private String newId;
	
	@ManyToOne
	@JoinColumn(name="tid")
	private Topic topic;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="news")
	private Set<Comments> comment = new HashSet<Comments>(0);
	
	@Column
	private String newTitle;
	
	@Column
	private String newAuthor;

	@Column
	private String newCreatedate;
	
	@Column
	private String newPicpath;
	
	@Column()
	@Basic(fetch=FetchType.LAZY)
	@Type(type="text")
	private String newContent;
	
	@Column
	private Date newModifydate;
	
	@Column
	private String newSummary;
	
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}

	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewAuthor() {
		return newAuthor;
	}
	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}
	public String getNewCreatedate() {
		return newCreatedate;
	}
	public void setNewCreatedate(String newCreatedate) {
		this.newCreatedate = newCreatedate;
	}
	public String getNewPicpath() {
		return newPicpath;
	}
	public void setNewPicpath(String newPicpath) {
		this.newPicpath = newPicpath;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public Date getNewModifydate() {
		return newModifydate;
	}
	public void setNewModifydate(Date newModifydate) {
		this.newModifydate = newModifydate;
	}
	public String getNewSummary() {
		return newSummary;
	}
	public void setNewSummary(String newSummary) {
		this.newSummary = newSummary;
	}
	public Set<Comments> getComment() {
		return comment;
	}
	public void setComment(Set<Comments> comment) {
		this.comment = comment;
	}

	
	
}
