package org.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.google.gson.Gson;
import com.news.service.TopicServiceI;

@ContextConfiguration(locations={"classpath:applicationContext.xml"})
/*
 *AbstractTransactionalJUnit4SpringContextTests ,会帮忙管理session，测试成功会会回滚，不会
 *污染数据库数据，自增长什么的貌似会改变
 */
public class TestSessionFactory 
					extends AbstractTransactionalJUnit4SpringContextTests {

	
	@Autowired
	private TopicServiceI topicService;
	
	
	@Test
	public void test1(){
		System.out.println(topicService.getAllList());
	}

}
