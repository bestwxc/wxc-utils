package net.wxc.io.utils;

import java.io.File;

public class ErrorHandler {
	public void handleOnDeleteError(File f){
		throw new RuntimeException("ɾ���ļ�ʱ���������ļ�Ϊ��" + f.getAbsolutePath());
	}
}
