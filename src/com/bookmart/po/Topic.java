package com.news.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 新闻主题
 * 
 * @author YangChaoMin 2013-7-15 上午10:44:23
 */
@Entity
@Table(name = "news_topic")
public class Topic extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String INLAND = "1";
	public final static String FOREIGN = "2";
	public final static String FUN = "3";

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	private String id;

	@Column
	private String topicName;

	@OneToMany(mappedBy = "topic")
	private Set<News> news = new HashSet<News>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Set<News> getNews() {
		return news;
	}

	public void setNews(Set<News> news) {
		this.news = news;
	}

}
