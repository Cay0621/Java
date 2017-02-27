package Singleton;

/**
 * 单例模式：任何情况下，该类只能创建一个实例
 * 
 * 三步：
 * 	1、定义一个私有的静态的当前类的属性
 * 	2、私有化构造方法，不允许外界随意创建类的实例
 * 	3、定义一个静态的可以获取当前类实例的方法，
 * 		从这个方法中可以判断是否创建过实例，
 * 		如果未创建，则创建实例，如果已创建过，则直接返回当前实例，从而达到单例效果
 * 
 * @author 木石前盟Cam
 *
 */
public class SingletonTest {
	
	private static SingletonTest obj = null;
	//构造私有构造函数
	private SingletonTest(){
		
	}
	
	//定义公有的静态方法用于获取当前实例
	public static SingletonTest getInstance(){
		if(obj == null)
			obj = new SingletonTest();
		return obj;
	}
}