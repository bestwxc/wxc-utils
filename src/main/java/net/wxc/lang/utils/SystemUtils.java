package net.wxc.lang.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;

public class SystemUtils {
	
	public static String getSystemProperty(SystemPropertiesKeys key){
		return System.getProperty(key.getValue());
	}
	
}
