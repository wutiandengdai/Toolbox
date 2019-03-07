package com.github.toolbox.java_utils.files;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件前缀枚举
 * @author ucs_yelei
 * @date 2017-02-20
 */
public enum FilePrefixEnum {
		CBALANCE("current-balance"),		//活期余额文件
		CAMOUNT("current-amount");		//活期发生额文件
	    
	    private String text;
	    
	    FilePrefixEnum(String text) {
	        this.text = text;
	    }
	    
	    public String getText() {
	        return this.text;
	    }
	    
	    // Implementing a fromString method on an enum type
	    private static final Map<String, FilePrefixEnum> stringToEnum = new HashMap<String, FilePrefixEnum>();
	    static {
	        // Initialize map from constant name to enum constant
	        for(FilePrefixEnum prefix : values()) {
	            stringToEnum.put(prefix.toString(), prefix);
	        }
	    }
	    
	    // Returns 枚举类 from string, or null if string is invalid
	    public static FilePrefixEnum fromString(String symbol) {
	        return stringToEnum.get(symbol);
	    }

	    @Override
	    public String toString() {
	        return text;
	    }
}
