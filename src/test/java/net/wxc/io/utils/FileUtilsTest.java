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
		Assert.assertFalse("尝试刪除" + baseDir.getAbsolutePath() + "文件夹，请手工删除",baseDir.exists());
		File dirs = new File(baseDir,"child1/child2/child3/child4/child5");
		Assert.assertTrue(dirs.getAbsolutePath() + "创建失败",dirs.mkdirs());
		Assert.assertTrue(dirs.getAbsolutePath() + "创建失败",baseDir.exists());
		FileUtils.rmdirs(baseDir);
		Assert.assertFalse(baseDir.getAbsolutePath() + "未刪除成功，文件仍然存在",baseDir.exists());
	}
}
