package com.news.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json转换工具类
 * 
 * @author 杨超民 2013-7-18 下午1:33:47
 * 
 */
public class JSONUtil {

	/**
	 * 向客户端输出
	 * 
	 * @param response
	 * @param json
	 * @throws IOException
	 */
	public static void outString(HttpServletResponse response, String json) throws IOException {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	


	   /***
  * 将List对象序列化为JSON文本
  */
 public static <T> String toJSONString(List<T> list)
 {
     JSONArray jsonArray = JSONArray.fromObject(list);

     return jsonArray.toString();
 }
 
 /***
  * 将对象序列化为JSON文本
  * @param object
  * @return
  */
 public static String toJSONString(Object object)
 {
     JSONArray jsonArray = JSONArray.fromObject(object);

     return jsonArray.toString();
 }

 /***
  * 将JSON对象数组序列化为JSON文本
  * @param jsonArray
  * @return
  */
 public static String toJSONString(JSONArray jsonArray)
 {
     return jsonArray.toString();
 }

 /***
  * 将JSON对象序列化为JSON文本
  * @param jsonObject
  * @return
  */
 public static String toJSONString(JSONObject jsonObject)
 {
     return jsonObject.toString();
 } 
	
	
}
