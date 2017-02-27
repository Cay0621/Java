/**
 * 通过不同的方式创建线程
 */
package ThreadTest_1;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Cat cat = new Cat();
		
		//cat.start();//继承线程类，启动线程,触发run函数的运行
		
		Dog dog = new Dog();//通过Runnable接口
		Thread dogThread = new Thread(dog);
		dogThread.start();
	}

}

class Cat extends Thread
{
	int times = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(times < 10)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("ok:" + times);
		}
	}
}

class Dog implements Runnable
{
	int times = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(times < 10)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("ok:" + times);
		}
	}
	
}