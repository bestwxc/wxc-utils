package net.wxc.io.utils;

import java.io.File;

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
}
