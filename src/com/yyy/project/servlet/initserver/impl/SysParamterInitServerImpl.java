package com.yyy.project.servlet.initserver.impl;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.yyy.project.servlet.initserver.IToftInitServer;

/**
 *   @类名： SysParamterInitServerImpl
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2016-1-1 上午10:42:35
 *   @修改人：
 *   @修改时间：  
 **/
public class SysParamterInitServerImpl implements IToftInitServer {

	private static Logger _log = Logger.getLogger(SysParamterInitServerImpl.class);

	public static String split_str = ":|:";

	/**
	 *   @生成时间： 2016-1-1 上午11:37:09
	 *   @方法说明： 初始化加载后执行的方法
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public boolean execute(ApplicationContext appctx) {
		try {
//			ToftCache cache = new ToftCacheFactoryImpl().createEhcache();
//			System.out.println(cache.getObject("error_001", CacheType.CACHETYPE_EH_FOREVER).toString());
//			Iterator<?> it = LoadErrorProperties.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
//				String key = entry.getKey().toString();
//				Object value = entry.getValue();
//				cache.setObject(key, value, CacheType.CACHETYPE_EH_FOREVER);
//			}
		} catch (Exception ex) {
			_log.error("参数加载失败.", ex);
			return false;
		}
		return true;
	}

	public void destroy() {
	}

}
