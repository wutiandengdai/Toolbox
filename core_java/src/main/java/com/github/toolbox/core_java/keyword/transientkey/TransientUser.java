package com.github.toolbox.core_java.keyword.transientkey;

import java.io.Serializable;

/**包含非持久化成员变量的可持久化类
 * @author ucs_yelei
 *
 */
public class TransientUser implements Serializable {
	private static final long serialVersionUID = -7159192156541371057L;
	
	private String username;
	/**
	 * 非持久化
	 */
	private transient String password;
	
	public TransientUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
