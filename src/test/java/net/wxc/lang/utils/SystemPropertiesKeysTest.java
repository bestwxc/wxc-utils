package net.wxc.lang.utils;

import org.junit.Test;

import net.wxc.lang.utils.SystemPropertiesKeys;

public class SystemPropertiesKeysTest {
	@Test
	public void test(){
		SystemPropertiesKeys[] values = SystemPropertiesKeys.values();
		for(SystemPropertiesKeys keys : SystemPropertiesKeys.values()){
			System.out.println(keys + ":" + keys.getValue());
		}
	}
}
