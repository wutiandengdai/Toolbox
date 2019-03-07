package com.github.toolbox.core_java.keyword.statickey;

public class StaticOuter {
	
	static int member = 0;
	int _member = 0;
	
	static void print(){
		System.out.println("Static method in outer class.");
	}
	
	void _print(){
		System.out.println("Non static method in outer class.");
	}
	
	
	public static class StaticInner{															//1、静态内部类只允许定义为内部类
		String _inner_member = "non-static member static inner";				//2、静态内部类允许定义非静态成员变量
		
		static void inner_print(){
			 member++;
//			_member++;																			//3、静态内部类不允许访问外部非静态变量
			 print();
//			 _print();																					//4、静态内部类允许定义非静态方法
			System.out.println("Static method in inner static class.");
		}
		
		void _inner_print(){																		
			member++;
//			_member++;																
			 print();
//			 _print();
			System.out.println("Non static method in inner static class.");		
		}
	}
	
	public class NonStaticInner{
//		static String inner_member = "static member nonstatic inner";		 //5、非静态内部类不可定义静态成员变量
//		static void print(){																		      //6、非静态内部类不可定义静态方法
//		}
		void inner_print(){
			System.out.print("Non-staic method in non-static inner class ");
		}
	}
	
	public static void main(String args[]){
		StaticOuter.StaticInner innerStatic = new StaticOuter.StaticInner();	//7、外部类.内部类创建
		StaticOuter.NonStaticInner innerNonstatic = new StaticOuter().new NonStaticInner();	//8、外部类实例.内部类实例创建
		
		StaticOuter.StaticInner.inner_print();
	}
	
}
