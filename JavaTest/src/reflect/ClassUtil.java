package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * 获取成员变量信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printClassFieldMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("类名称" + c.getName());
		/**
		 * 成员变量
		 */
		//Field[] fs = c.getFields();//所有public成员变量信息
		Field[] fs = c.getDeclaredFields();//所有该类自己声明的成员变量信息
		
		for (Field field : fs) {
			//得到成员变量的类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			
			//成员变量的名称
			String fieldName = field.getName();
			System.out.println(typeName + "," + fieldName);
		}
	}

	/**
	 * 获取成员函数信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printClassMethodMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("类名称" + c.getName());
		/**
		 * 成员函数
		 */
		Method[] ms1 = c.getMethods();//获取所有public函数，包括父类继承过来的函数
		//Method[] ms2 = c.getDeclaredMethods();//获取所有该类自己的声明方法，不管访问权限
		for (Method method : ms1) {
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName() + " ");//返回值名称
			System.out.print(method.getName() + "(");//方法名称
			
			//获取参数类型，---->得到的是参数列表的类型的类类型
			Class[] paramTypes = method.getParameterTypes();
			
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
			
		}
	}
	
	/**
	 * 获取构造函数信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printClassConstructor(Object obj){
		Class c = obj.getClass();
		
		/**
		 * 
		 */
		
		//Constructor[] cs = c.getConstructors();//得到所有public的构造函数
		Constructor[] cs = c.getDeclaredConstructors();//得到所有该类自己声明的构造函数
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName() + "(");
			//获得构造函数参数的类型的类类型
			Class[] paramType = constructor.getParameterTypes();
			
			for (Class class1 : paramType) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
		
	}
	
	
}
