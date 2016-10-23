package net.wxc.security.utils;

import java.io.File;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import net.wxc.io.utils.FileUtils;

public class RSAUtilsTest {
	private static PublicKey publicKey;
	private static PrivateKey privateKey;
	private static RSAUtils utils;
	
	private String testString = "曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。";
	
	@Test
	public void test(){
		this.testPublicKeyEncodeAndDecode();
		this.testPrivateKeyEncodeAndDecode();
		testString = "曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。";
		this.testPublicKeyEncodeAndDecode();
		this.testPrivateKeyEncodeAndDecode();
	}
	
	@BeforeClass
	public static void beforeClass(){
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			byte[] data = FileUtils.readByteFromFile(new File("src/test/resources/public.key"));
			publicKey =  keyFactory.generatePublic(new X509EncodedKeySpec(data));
			data = FileUtils.readByteFromFile(new File("src/test/resources/private.key"));
			privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(data));
			utils  = new RSAUtils(publicKey, privateKey,2048);
		} catch (Exception e) {
			Assert.assertTrue("beforeClass出现错误" + e.getMessage(), false);
		} 
		
	}
	
	@Before
	public void beforeTest(){
		utils.initPublicKeyEncode();
		utils.initPublicKeyDecode();
		utils.initPrivateKeyEncode();
		utils.initPrivateKeyDecode();
	}
	public void testPublicKeyEncodeAndDecode(){
		try {
			byte[] out1 = utils.publicKeyEncode(testString.getBytes());
			System.out.println("加密后字串，使用HEX表示：");
			System.out.println(Hex.toHexString(out1));
			byte[] out2 = utils.privateKeyDecode(out1);
			System.out.println("解密得到内容");
			System.out.println(new String(out2));
		} catch (GeneralSecurityException e) {
			Assert.assertTrue("publicKey加解密出现错误：" + e.getMessage(), false);
		}
		
	}
	
	public void testPrivateKeyEncodeAndDecode(){
		try {
			byte[] out1 = utils.privateKeyEncode(testString.getBytes());
			System.out.println("加密后字串，使用HEX表示：");
			System.out.println(Hex.toHexString(out1));
			byte[] out2 = utils.publicKeyDecode(out1);
			System.out.println("解密得到内容");
			System.out.println(new String(out2));
		} catch (GeneralSecurityException e) {
			Assert.assertTrue("publicKey加解密出现错误：" + e.getMessage(), false);
		}
	}
	
}
