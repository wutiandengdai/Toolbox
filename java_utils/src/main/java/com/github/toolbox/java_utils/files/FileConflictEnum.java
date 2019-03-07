package com.github.toolbox.java_utils.files;

/**
 * 文件冲突解决
 * @author ucs_yelei
 *	1）替换；2）忽略——重命名为 XXX1；3）放弃操作
 */
public enum FileConflictEnum {
	REPLACE, 
	IGNORE,
	ABORT;
}
