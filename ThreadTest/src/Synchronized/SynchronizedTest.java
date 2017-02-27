package Synchronized;

/**
 * 多线程并发安全问题
 * 
 * synchronized:关键字，线程安全锁
 * synchronized可以修饰方法，也可以单独作为语句块存在
 * synchronized的作用是限制多线程并发时间同时访问该作用域
 * 
 * @author 木石前盟Cam
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
	 * synchronized修饰方法后，方法就不是异步的，而是同步的了
	 * synchronized会为方法上锁
	 */
	synchronized void getMoney(int money) {
		if (account == 0)
			throw new RuntimeException("余额为0.");
		Thread.yield();
		account -= money;
	}
	
	//synchroinzed同步代码块
	//synchroinzed(Object){需要同步的代码块}
	//注意：Object要确保所有线程看到的是同一个对象
	
//	void getMoney(int money) {
//		synchronized(this){
//			if (account == 0)
//				throw new RuntimeException("余额为0.");
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
				System.out.println("余额为：" + account);
				Thread.yield();
			}
		}

	}
}