package com.news.po;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * 所有实体类的父类
 * @author 杨超民  2013-7-16  下午5:16:40
 *
 */
public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

