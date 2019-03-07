package com.github.toolbox.core_java.keyword.statickey;

public class StaticBase {
	
	static int count = 0;				//静态成员变量
	int _count = 0;						//非静态成员变量
	
	static void accumulate(){
		count++;							//1、静态方法能调用静态成员变量
//		_count++;						//		静态方法不能调用非静态成员变量
//		_accumulate();					//		静态方法不能调用非静态成员变量
	}
	
	void _accumulate(){
		count++;							//2、普通方法能调用静态成员变量
		_count++;						//		普通方法能调用非静态成员变量
		accumulate();					//     普通方法能调用静态方法
	}
	
	void __accumulate(){
//		static int __count;				//3、方法变量不能定义为静态类
	}
	
	
	static void  foo(){
		System.out.println("Base static method");
	}
	
//	void foo(){							//4、不能通过static区分不同方法
//	}
	
	void joo(){
		System.out.println("Base non-static method");
	}
	
	public static void main(String[] args){
//		System.out.println(this._count);
		
	}
}