package com.yc.spring;

public class Hello {
	public Hello() {
		//无参构造函数
		System.out.println("=======Hello无参构造函数=======");
	}
	public Hello(int a) {
		//有参构造函数
		System.out.println("=======Hello有参构造函数=======");
	}
	public void sayHello() {
		System.out.println("你好世界");
		
	}
	
	
	/*
	 * 生命周期方法不能带参数
	 */
	public void init() {
		System.out.println("========hello被创建=========");
	}
	
	public void destroy() {
		System.out.println("======hello被销毁=======");
		
	}

}
