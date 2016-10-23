package net.wxc.security.utils;

import java.io.File;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.junit.Test;

import net.wxc.io.utils.FileUtils;

public class RSAUtilsTestTools {
	/**
	 * 生成测试使用的key:2048bit
	 */
	@Test
	public void generateKeyPair(){
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			FileUtils.writeByteToFile(new File("src/test/resources/public.key"), publicKey.getEncoded());
			FileUtils.writeByteToFile(new File("src/test/resources/private.key"), privateKey.getEncoded());
		} catch (Exception e) {
			System.err.println("生成RSAkey文件错误：" + e.getMessage());
		}
	}
	
}
