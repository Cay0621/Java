package ThreadTest_2;

public class ThreadTest {
	public static void main(String[] args)
	{
		//һ���߳���ֻ�������߳�һ��
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