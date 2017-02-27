package ThreadTest_2;

public class ThreadTest {
	public static void main(String[] args)
	{
		//一个线程类只能启动线程一次
		try
		{
			Cat cat = new Cat();
			cat.start();
			//cat.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

class Cat extends Thread
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("11");
	}
}

class Dog implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("22");
	}
	
}