package com.yyy.util;

import java.util.UUID;

/**
 *   @类名： FileUtil
 *   @描述： 文件工具类
 *   @作者： 杨文胜
 *   @生成时间： 2014-6-3 下午06:00:44
 *   @修改人：
 *   @修改时间：  
 **/
public class FileUtil {
	/**
	 *   @生成时间： 2014-6-3 下午06:03:19
	 *   @方法说明： 获取excel的文件名称,生成24位的UUID(时间精确到毫秒 + JDK中生成的UUID前7位)
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getRandomFileName() {
		return DateFormatTools.getDateTimeStr() + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7).toUpperCase();	//拼接15为时间字符串 和 UUID的前5位代码
	}
}
