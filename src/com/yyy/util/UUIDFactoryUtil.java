package com.yyy.util;

import java.util.UUID;

/**
 *   @类名： UUIDFactoryUtil
 *   @描述： 生成UUID
 *   @作者： 杨文胜
 *   @生成时间： 2014-8-2 上午11:00:49
 *   @修改人：
 *   @修改时间：  
 **/
public class UUIDFactoryUtil {
	/**
	 *   @生成时间： 2014-8-2 上午11:00:21
	 *   @方法说明： 生成UUID
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getUUID() {
		String dt_15 = DateFormatTools.getDateTimeStr();	//获得“yyMMddHHmmssSSS”格式的时间字符串
		String uuid_5 = UUID.randomUUID().toString().substring(0, 5);	//截取UUID的前5位代码
		return dt_15+uuid_5;	//拼接15为时间字符串 和 UUID的前5位代码
	}
	/**
	 *   @生成时间： Aug 7, 2014 10:43:47 AM
	 *   @方法说明： 时间uuid
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String generateUUID(){
		return UUID.randomUUID().toString().substring(0, 19) + DateFormatTools.getDateTimeStr();
	}
	/**
	 *   @生成时间： 2014-10-15 上午11:19:46
	 *   @方法说明：	治安防控的唯一标识
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String generateZafkUUID(){
		String uuid = "zk_";
		uuid += UUID.randomUUID().toString().replace("-", "").substring(3);
		return uuid;
	}
}
