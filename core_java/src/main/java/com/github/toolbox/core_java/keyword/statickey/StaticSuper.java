package com.github.toolbox.core_java.keyword.statickey;

public class StaticSuper extends StaticBase {

	static final int BASE = 3;
	static int multiply = 1;
	int _multiply;
	
	static void product(){
//		multiply = BASE * super.count;				//1、 super指向的是实例，不能在静态环境下引用非静态
//		_multiply = BASE * super._count;			//同上
	}	
	
	void _product(){
		multiply = BASE * super.count;			//2、能在非静态上线文中引用非静态（super）
		_multiply = BASE * super._count;			//同上
	}
	
	static void init(){
//		this.multiply = 1;									//3、 this指向的是实例，不能在静态环境下引用非静态
//		this._multiply = 1;
	}
	
	void _init(){
//		this.multiply = 1;									//4、能在非静态上线文中引用非静态（this）
		this._multiply = 1;
	}
	
	static void foo(){										//5、静态方法调用对象声明基类
		System.out.println("Super Class override static method");
	}
	
//	static void foo(int i){									//6、子类静态方法可重载父类静态方法
//	}
	
//	void foo(){												//7、非静态方法不能覆盖基态静态方法
//	}
	
//	static void joo(){										//8、静态方法不能覆盖父类非静态方法
//	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticBase sm = new StaticSuper();
		sm.accumulate();								
	}

}
