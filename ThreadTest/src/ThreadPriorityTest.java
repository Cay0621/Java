/**
 * yield():��������ʱ��Ƭ����������Runnable״̬
 * setPriority():�����߳����ȼ�
 * @author ľʯǰ��Cam
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
