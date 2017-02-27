package Genericity;

import java.lang.reflect.Method;

public class GenericityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String> gS = new Gen<String>("cay");
		gS.getTypeName();
		
		Gen<Integer> gI = new Gen<Integer>(123);
		gI.getTypeName();
		
		Gen<Bird> gB = new Gen<Bird>(new Bird());
		gB.getTypeName();
	}
}

class Bird
{
	public void fly()
	{
		System.out.println("Fly");
	}
	
}

class Gen<T>
{
	private T o;
	
	public Gen(T o) {
		this.o = o;
	}
	
	public void getTypeName()
	{
		System.out.println("类型名" + o.getClass().getName());
		
		//通过反射机制,可以得到T的类型信息
		Method[] ms = o.getClass().getDeclaredMethods();
		for(Method m : ms)
		{
			System.out.println(m.getName());
		}
	}
}