package com.github.toolbox.core_java.concurrency.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * HashMap 的线程不安全，可能造成死循环（Java 6）
 * Rehash- 创建新容器，将原key-value对的值拷贝到扩容后的容器。
 * @author ucs_yelei
 *
 */
public class HashMapConcurrency {

	public static void main(String[] args){
		//设置较小初始容量，以增加hashmap扩容频率。
		final HashMap<String, String> map = new HashMap<String, String>(2);

		Thread t = new Thread(new Runnable(){
			public void run() {
				for(int i = 1; i <= 10000; i++){

					new Thread(new Runnable(){
						public void run() {
							map.put(UUID.randomUUID().toString(), "1");
						}
						
					}, "thread"+i).start();
				}
			}
		}, "Thread0");

		t.start();

		try {
			t.join(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(map.size());		//9999
	}
}
