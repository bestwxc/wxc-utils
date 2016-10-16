package net.wxc.lang.utils;
import org.junit.Test;

import net.wxc.lang.utils.SystemPropertiesKeys;
import net.wxc.lang.utils.SystemUtils;

public class SystemUtilsTest {
	
	@Test
	public void testGetSystemProperty(){
		for(SystemPropertiesKeys keys : SystemPropertiesKeys.values()){
			System.out.println(keys + ":" + SystemUtils.getSystemProperty(keys));
		}
	}
}
