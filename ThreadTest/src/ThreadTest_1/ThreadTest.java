/**
 * ͨ����ͬ�ķ�ʽ�����߳�
 */
package ThreadTest_1;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Cat cat = new Cat();
		
		//cat.start();//�̳��߳��࣬�����߳�,����run����������
		
		Dog dog = new Dog();//ͨ��Runnable�ӿ�
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