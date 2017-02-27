public class InterruptedExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * 方法中定义的类叫做局部内部类
		 * 局部内部类中若想引用当前方法的其他局部变量，那么该变量必须是final的
		 */
		final Thread t1 = new Thread() {
			@Override
			public void run() {
			
				// TODO Auto-generated method stub
				// super.run();
				while (true) {
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						System.out.println("被中断了。。。");
					}

				}
			}

		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// super.run();
				for (int i = 1; i <= 5; ++i) {
					System.out.println(i + "次");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				t1.interrupt();//将t1线程中断
			}

		};
		t1.start();
		t2.start();
	}

}
