/**
 * ���̲߳��԰���,����߳�ͬʱ����
 */
package ThreadTest_1;

public class ThreadTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig = new Pig(10);
		Bird bird = new Bird(10);
		
		Thread pigThread = new Thread(pig);
		Thread birdThread = new Thread(bird);
		
		pigThread.start();
		birdThread.start();
	}
}

//����
class Bird implements Runnable
{
	int n = 0;
	int res = 0;
	int times = 0;

	public Bird(int n) {
		super();
		this.n = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(times < n)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res += (++times);
			System.out.println("��ǰ�����" + res);
		}
		System.out.println("����ǣ�" + res);
	}
}

class Pig implements Runnable
{
	public Pig(int n) {
		super();
		this.n = n;
	}
	int n = 0;
	int times = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(times < n)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("����һ���̣߳��������" + times + "��hello,world");
		}
	}
	
}