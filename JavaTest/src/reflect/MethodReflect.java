package reflect;

import java.lang.reflect.Method;

public class MethodReflect {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 要获取print(int,int)方法

		// 1、获取类信息，首先要获得类的类类型
		A a1 = new A();
		Class c = a1.getClass();

		// 2、获取方法，名称和参数列表信息，getMethod获取的是public方法

		try {
			// Method m = c.getMethod("print", new Class[]{int.class,
			// int.class});
			Method m1 = c.getMethod("print", int.class, int.class);

			// 方法的反射操作

			// 方法如果没有返回值，则返回null，有返回值则返回具体的返回值
			m1.invoke(a1, 3, 4);
			
			System.out.println("=====================");
			Method m2 = c.getMethod("print", String.class, String.class);
			m2.invoke(a1, "hello", "WORLD");
			
			System.out.println("=====================");
			
			Method m3 = c.getMethod("print");
			m3.invoke(a1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class A {
	
	public void print(){
		System.out.println("Hello World");
	}
	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}