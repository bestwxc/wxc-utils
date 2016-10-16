package net.wxc.io.utils;

import java.io.File;

public class FileUtils {
	public static void rmdirs(File f){
		rmdirs(f,null);
	}
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
