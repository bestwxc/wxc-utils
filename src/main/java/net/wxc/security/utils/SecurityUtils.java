package net.wxc.security.utils;

import java.security.Provider;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

public class SecurityUtils {
	/**
	 * 列出所有java安全框架支持的服务
	 */
	public static void listService(){
		//Map<String,String> map = new HashMap<String,String>();
		String[] ss = {"CertificateFactory","CertPathBuilder","CertPathValidator"
				,"CertStore","AlgorithmParameterGenerator","AlgorithmParameters"
				,"KeyFactory","KeyPairGenerator","KeyStore","MessageDigest"
				,"Policy","SecureRandom","Signature"};
		for(String s : ss){
			System.out.println(s + ":");
			for(String alg : Security.getAlgorithms(s)){
				System.out.println(alg);
			}
			System.out.println();
		}
	}
	
	public static void listProvider(){
		System.out.println("-------列出加密服务提供者-----");
		Provider[] provider = Security.getProviders();
		for(Provider p : provider){
			System.out.println("Provider:"+p.getName()+" - version:"+p.getVersion());
			System.out.println(p.getInfo());
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		listProvider();
		listService();
	}
}
