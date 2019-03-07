package com.github.toolbox.java_utils.files;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件格式，目前设计仅支持CSV与TXT格式
 * @author ucs_yelei
 *
 */
public enum FileEnum {
	CSV("csv"),
	TXT("txt"),
	XML("xml");
	
	 private String text;
	    
	 FileEnum(String text) {
	       this.text = text;
	}
	    
	 public String getText() {
	      return this.text;
	 }
	    
	 // Implementing a fromString method on an enum type
	private static final Map<String, FileEnum> stringToEnum = new HashMap<String, FileEnum>();
	static {
	  // Initialize map from constant name to enum constant
	     for(FileEnum prefix : values()) {
	          stringToEnum.put(prefix.toString(), prefix);
	      }
	}
	    
	 // Returns 枚举类 from string, or null if string is invalid
	public static FileEnum fromString(String symbol) {
	      return stringToEnum.get(symbol);
	}

	@Override
	public String toString() {
	     return text;
	}
}
