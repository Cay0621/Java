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
		 * wait()和notify()/notifyAll()在同步的时候，
		 * 规定同步的对象Object是调用方法的对象
		 * 
		 */
		synchronized(bank){
			//bank.notify();//只随机唤醒其中一个在此对象身上wait的线程
			bank.notifyAll();//唤醒所有在此对象(此处为bank对象)身上wait的线程
		}
	}

}

class Bank {
	public int account;

	/**
	 * synchronized修饰方法后，方法就不是异步的，而是同步的了 synchronized会为方法上锁
	 */
	synchronized void getMoney(int money) {
		if (account == 0)
			throw new RuntimeException("余额为0.");
		Thread.yield();
		account -= money;
	}

	// synchroinzed同步代码块
	// synchroinzed(Object){需要同步的代码块}
	// 注意：Object要确保所有线程看到的是同一个对象

	// void getMoney(int money) {
	// synchronized(this){
	// if (account == 0)
	// throw new RuntimeException("余额为0.");
	// Thread.yield();
	// account -= money;
	// }
	// }

	class Person extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// super.run();
			System.out.println("准备取钱，等待银行开门...");
			
			try {
				/**
				 * wait()和notify()/notifyAll()在同步的时候，
				 * 规定同步的对象Object是调用方法的对象
				 * 
				 */
				synchronized(Bank.this){
					//当前线程在Bank对象上wait
					Bank.this.wait();//调用外部类的方法，需要加上外部类名+this+外部类方法名
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while (true) {
				getMoney(100);
				System.out.println("余额为：" + account);
				Thread.yield();
			}
		}

	}

}
