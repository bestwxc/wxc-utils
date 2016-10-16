package net.wxc.io.utils;

import java.io.File;

public class ErrorHandler {
	public void handleOnDeleteError(File f){
		throw new RuntimeException("删除文件时发生错误，文件为：" + f.getAbsolutePath());
	}
}
