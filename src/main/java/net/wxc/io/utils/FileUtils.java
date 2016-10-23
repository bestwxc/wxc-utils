package net.wxc.io.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件工具类
 * @author Cheng
 * 
 */
public class FileUtils {
	
	/**
	 * 删除目录
	 * @param f
	 */
	public static void rmdirs(File f){
		rmdirs(f,null);
	}
	/**
	 * 删除目录
	 * @param f
	 * @param handler
	 */
	public static void rmdirs(File f,ErrorHandler handler){
		if(f.isDirectory()){
			File[] files = f.listFiles();
			for(int i = 0; i < files.length; i++){
				rmdirs(files[i],handler);
			}
		}
		if(!f.delete() && handler != null){
			handler.handleOnDeleteError(f);
		}
	}
	
	/**
	 * 将字节数组写入文件
	 * @param file
	 * @param data
	 * @throws IOException
	 */
	public static void writeByteToFile(File file,byte[] data) throws IOException{
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(data);
			outputStream.flush();
		} catch (Exception e) {
			throw new IOException("写入文件错误：" + e.getMessage());
		}finally {
			if(outputStream != null){
				try {
					outputStream.close();
				}finally {
					outputStream = null;
				}
			}
		}
	}
	
	/**
	 * 从文件中读出字节数组
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] readByteFromFile(File file) throws IOException{
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			return data;
		} catch (Exception e) {
			throw new IOException("读出文件错误：" + e.getMessage());
		}finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} finally {
					inputStream = null;
				}
			}
		}
	}
}
