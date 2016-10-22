package net.wxc.security.utils;

import java.io.ByteArrayOutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/**
 * @author Cheng
 * RSA加密工具类
 */
public class RSAUtils {
	
	private PublicKey publicKey;
	private PrivateKey privateKey;
	private Cipher publicKeyEncodeCipher;
	private Cipher publicKeyDecodeCipher;
	private Cipher privateKeyEncodeCipher;
	private Cipher privateKeyDecodeCipher;
	
	private int MAX_ENCODE_BYTE = 0;
	private int MAX_DECODE_BYTE = 0;
	
	public RSAUtils(){
		
	}
	
	public RSAUtils(PublicKey publicKey){
		//int keyByte = new X509EncodedKeySpec(publicKey.getEncoded()).
		this.publicKey = publicKey;
	}
	
	public RSAUtils(PrivateKey privateKey){
		this.privateKey = privateKey;
	}
	
	public RSAUtils(PublicKey publicKey,PrivateKey privateKey){
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}
	
	private void setKeyByte(Key key){
		int keyByte =  (int) Math.round(key.getEncoded().length/8.0);
		this.MAX_DECODE_BYTE = keyByte;
		this.MAX_ENCODE_BYTE = keyByte - 11;
	}
	
	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public void initPublicKeyEncode(){
		try {
			this.setKeyByte(publicKey);
			publicKeyEncodeCipher = Cipher.getInstance("RSA");
			publicKeyEncodeCipher.init(Cipher.ENCRYPT_MODE, publicKey);
		} catch (Exception e) {
			System.err.println("初始化错误" + e.getMessage());
			publicKeyEncodeCipher = null;
		}
	}
	
	public void initPublicKeyDecode(){
		try {
			this.setKeyByte(publicKey);
			publicKeyDecodeCipher = Cipher.getInstance("RSA");
			publicKeyDecodeCipher.init(Cipher.DECRYPT_MODE, publicKey);
		} catch (Exception e) {
			System.err.println("初始化错误" + e.getMessage());
			publicKeyDecodeCipher = null;
		}
	}
	
	public void initPrivateKeyEncode(){
		try {
			this.setKeyByte(privateKey);
			privateKeyEncodeCipher = Cipher.getInstance("RSA");
			privateKeyEncodeCipher.init(Cipher.ENCRYPT_MODE, privateKey);
		} catch (Exception e) {
			System.err.println("初始化错误" + e.getMessage());
			privateKeyEncodeCipher = null;
		}
	}
	
	public void initPrivateKeyDecode(){
		try {
			this.setKeyByte(privateKey);
			privateKeyDecodeCipher = Cipher.getInstance("RSA");
			privateKeyDecodeCipher.init(Cipher.DECRYPT_MODE, privateKey);
		} catch (Exception e) {
			System.err.println("初始化错误" + e.getMessage());
			privateKeyDecodeCipher = null;
		}
	}
	
	private byte[] convert(byte[] data,Cipher cipher,int max_convert_byte) throws GeneralSecurityException{
		if(cipher != null){
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int dataLength = data.length;
				int offset = 0;
				int convert_byte = 0;
				byte[] cache;
				while((convert_byte = dataLength - offset) > 0){
					convert_byte = Math.min(convert_byte, max_convert_byte);
					cache = cipher.doFinal(data, offset, convert_byte);
					out.write(cache);
					offset += convert_byte;
				}
				return out.toByteArray();
			} catch (Exception e) {
				throw new GeneralSecurityException("加/解密错误：" + e.getMessage());
			} 
		}else{
			throw new GeneralSecurityException("请先初始化cipher");
		}
	}
	
	public byte[] publicKeyEncode(byte[] data) throws GeneralSecurityException{
		return this.convert(data, publicKeyEncodeCipher, MAX_ENCODE_BYTE);
	}
	
	public byte[] publicKeyDecode(byte[] data) throws GeneralSecurityException{
		return this.convert(data, publicKeyDecodeCipher, MAX_DECODE_BYTE);
	}
	
	public byte[] privateKeyEncode(byte[] data) throws GeneralSecurityException{
		return this.convert(data, privateKeyEncodeCipher, MAX_ENCODE_BYTE);
	}
	
	public byte[] privateKeyDecode(byte[] data) throws GeneralSecurityException{
		return this.convert(data, privateKeyDecodeCipher, MAX_DECODE_BYTE);
	}
}
