package Wait;

public class WaitTest {

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
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bank.account = 10000;
		
		/**
		 * wait()��notify()/notifyAll()��ͬ����ʱ��
		 * �涨ͬ���Ķ���Object�ǵ��÷����Ķ���
		 * 
		 */
		synchronized(bank){
			//bank.notify();//ֻ�����������һ���ڴ˶�������wait���߳�
			bank.notifyAll();//���������ڴ˶���(�˴�Ϊbank����)����wait���߳�
		}
	}

}

class Bank {
	public int account;

	/**
	 * synchronized���η����󣬷����Ͳ����첽�ģ�����ͬ������ synchronized��Ϊ��������
	 */
	synchronized void getMoney(int money) {
		if (account == 0)
			throw new RuntimeException("���Ϊ0.");
		Thread.yield();
		account -= money;
	}

	// synchroinzedͬ�������
	// synchroinzed(Object){��Ҫͬ���Ĵ����}
	// ע�⣺ObjectҪȷ�������߳̿�������ͬһ������

	// void getMoney(int money) {
	// synchronized(this){
	// if (account == 0)
	// throw new RuntimeException("���Ϊ0.");
	// Thread.yield();
	// account -= money;
	// }
	// }

	class Person extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// super.run();
			System.out.println("׼��ȡǮ���ȴ����п���...");
			
			try {
				/**
				 * wait()��notify()/notifyAll()��ͬ����ʱ��
				 * �涨ͬ���Ķ���Object�ǵ��÷����Ķ���
				 * 
				 */
				synchronized(Bank.this){
					//��ǰ�߳���Bank������wait
					Bank.this.wait();//�����ⲿ��ķ�������Ҫ�����ⲿ����+this+�ⲿ�෽����
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while (true) {
				getMoney(100);
				System.out.println("���Ϊ��" + account);
				Thread.yield();
			}
		}

	}

}
