package net.wxc.io.utils;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import net.wxc.io.utils.FileUtils;

public class FileUtilsTest {
	@Test
	public void rmdirs(){
		File baseDir = new File("D:/testDir");
		FileUtils.rmdirs(baseDir);
		Assert.assertFalse("���Ԅh��" + baseDir.getAbsolutePath() + "�ļ��У����ֹ�ɾ��",baseDir.exists());
		File dirs = new File(baseDir,"child1/child2/child3/child4/child5");
		Assert.assertTrue(dirs.getAbsolutePath() + "����ʧ��",dirs.mkdirs());
		Assert.assertTrue(dirs.getAbsolutePath() + "����ʧ��",baseDir.exists());
		FileUtils.rmdirs(baseDir);
		Assert.assertFalse(baseDir.getAbsolutePath() + "δ�h���ɹ����ļ���Ȼ����",baseDir.exists());
	}
}
