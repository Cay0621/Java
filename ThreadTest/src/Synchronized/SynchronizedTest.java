package Synchronized;

/**
 * ���̲߳�����ȫ����
 * 
 * synchronized:�ؼ��֣��̰߳�ȫ��
 * synchronized�������η�����Ҳ���Ե�����Ϊ�������
 * synchronized�����������ƶ��̲߳���ʱ��ͬʱ���ʸ�������
 * 
 * @author ľʯǰ��Cam
 *
 */

public class SynchronizedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		Bank.Person p1 = bank.new Person();
		Bank.Person p2 = bank.new Person();
		
		p1.start();
		p2.start();
	}

}

class Bank {
	int account = 10000;

	/**
	 * synchronized���η����󣬷����Ͳ����첽�ģ�����ͬ������
	 * synchronized��Ϊ��������
	 */
	synchronized void getMoney(int money) {
		if (account == 0)
			throw new RuntimeException("���Ϊ0.");
		Thread.yield();
		account -= money;
	}
	
	//synchroinzedͬ�������
	//synchroinzed(Object){��Ҫͬ���Ĵ����}
	//ע�⣺ObjectҪȷ�������߳̿�������ͬһ������
	
//	void getMoney(int money) {
//		synchronized(this){
//			if (account == 0)
//				throw new RuntimeException("���Ϊ0.");
//			Thread.yield();
//			account -= money;
//		}
//	}
	
	class Person extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// super.run();
			while (true) {
				getMoney(100);
				System.out.println("���Ϊ��" + account);
				Thread.yield();
			}
		}

	}
}