package net.wxc.lang.utils;

/**
 * ϵͳ������
 * @author Cheng
 *
 */
public class SystemUtils {
	
	public static String getSystemProperty(SystemPropertiesKeys key){
		return System.getProperty(key.getValue());
	}
	
}
