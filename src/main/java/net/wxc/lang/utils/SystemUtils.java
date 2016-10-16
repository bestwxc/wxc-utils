package net.wxc.lang.utils;

/**
 * 系统工具类
 * @author Cheng
 *
 */
public class SystemUtils {
	
	public static String getSystemProperty(SystemPropertiesKeys key){
		return System.getProperty(key.getValue());
	}
	
}
