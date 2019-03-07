package com.github.toolbox.core_java.keyword.transientkey;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * transient变量用于密码的场景
 * @author ucs_yelei
 * output:  Password Before Serialization: helloworld
 * Password After Serialization: null
 */
public class PasswordTransient {

	public static void main(String[] args) {
		TransientUser user = new TransientUser("java", "helloworld");
		System.out.println("Password Before Serialization: " + user.getPassword());
		
		//序列化
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("transientUser.txt"));
			oos.writeObject(user);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(oos != null){oos.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//读取反序列化数据
		ObjectInputStream ois =null;
		try {
			ois = new ObjectInputStream(new FileInputStream("transientUser.txt"));
			TransientUser userRead = (TransientUser)ois.readObject();
			System.out.println("Password After Serialization: " + userRead.getPassword());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
