package net.wxc.lang.utils;

/**
 * 系统属性枚举类
 * @author Cheng
 *
 */
public enum SystemPropertiesKeys {
	
	JAVA_RUNTIME_NAME("java.runtime.name"),
	SUN_BOOT_LIBRARY_PATH("sun.boot.library.path"),
	JAVA_VM_VERSION("java.vm.version"),
	JAVA_VM_VENDOR("java.vm.vendor"),
	JAVA_VENDOR_URL("java.vendor.url"),
	PATH_SEPARATOR("path.separator"),
	JAVA_VM_NAME("java.vm.name"),
	FILE_ENCODING_PKG("file.encoding.pkg"),
	SUN_JAVA_LAUNCHER("sun.java.launcher"),
	USER_COUNTRY("user.country"),
	SUN_OS_PATCH_LEVEL("sun.os.patch.level"),
	JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),
	USER_DIR("user.dir"),
	JAVA_RUNTIME_VERSION("java.runtime.version"),
	JAVA_AWT_GRAPHICSENV("java.awt.graphicsenv"),
	JAVA_ENDORSED_DIRS("java.endorsed.dirs"),
	OS_ARCH("os.arch"),
	JAVA_IO_TMPDIR("java.io.tmpdir"),
	LINE_SEPARATOR("line.separator"),
	JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),
	USER_VARIANT("user.variant"),
	OS_NAME("os.name"),
	SUN_JNU_ENCODING("sun.jnu.encoding"),
	JAVA_LIBRARY_PATH("java.library.path"),
	JAVA_SPECIFICATION_NAME("java.specification.name"),
	JAVA_CLASS_VERSION("java.class.version"),
	SUN_MANAGEMENT_COMPILER("sun.management.compiler"),
	OS_VERSION("os.version"),
	USER_HOME("user.home"),
	USER_TIMEZONE("user.timezone"),
	JAVA_AWT_PRINTERJOB("java.awt.printerjob"),
	FILE_ENCODING("file.encoding"),
	JAVA_SPECIFICATION_VERSION("java.specification.version"),
	JAVA_CLASS_PATH("java.class.path"),
	USER_NAME("user.name"),
	JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),
	SUN_JAVA_COMMAND("sun.java.command"),
	JAVA_HOME("java.home"),
	SUN_ARCH_DATA_MODEL("sun.arch.data.model"),
	USER_LANGUAGE("user.language"),
	JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),
	AWT_TOOLKIT("awt.toolkit"),
	JAVA_VM_INFO("java.vm.info"),
	JAVA_VERSION("java.version"),
	JAVA_EXT_DIRS("java.ext.dirs"),
	SUN_BOOT_CLASS_PATH("sun.boot.class.path"),
	JAVA_VENDOR("java.vendor"),
	FILE_SEPARATOR("file.separator"),
	JAVA_VENDOR_URL_BUG("java.vendor.url.bug"),
	SUN_IO_UNICODE_ENCODING("sun.io.unicode.encoding"),
	SUN_CPU_ENDIAN("sun.cpu.endian"),
	SUN_DESKTOP("sun.desktop"),
	SUN_CPU_ISALIST("sun.cpu.isalist");
	
	private String value;
	
	private SystemPropertiesKeys(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
}
