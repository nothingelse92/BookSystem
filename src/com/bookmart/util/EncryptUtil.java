package com.news.util;

import java.security.MessageDigest;

/**
 * 加密工具类
 * 
 * @author 杨超民 2013-7-17 下午1:18:01
 * 
 */
public class EncryptUtil {

	/**
	 * 加密
	 * 
	 * @param pwd
	 */
	public static String addMD5(String pwd) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pwd.getBytes());

		byte[] arr = md.digest();
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			buf.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return buf.toString();
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(addMD5("ss"));
//	}
}
