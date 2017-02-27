/**
 * yield():放弃当次时间片，主动进入Runnable状态
 * setPriority():设置线程优先级
 * @author 木石前盟Cam
 *
 */
public class ThreadPriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//super.run();
				for(int i = 0;i < 100;++i)
				{
					System.out.println(Thread.currentThread().getName());
					Thread.yield();
				}
			}
			
		};
		
		Thread t2 = new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//super.run();
				for(int i = 0;i < 100;++i)
				{
					System.out.println(Thread.currentThread().getName());
					Thread.yield();
				}
			}
			
		};
		
		Thread t3 = new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//super.run();
				for(int i = 0;i < 100;++i)
				{
					System.out.println(Thread.currentThread().getName());
					Thread.yield();
				}
			}
			
		};
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

}
