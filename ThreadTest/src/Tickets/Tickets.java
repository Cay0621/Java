package Tickets;

public class Tickets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TicketWindow tw1 = new TicketWindow();
//		TicketWindow tw2 = new TicketWindow();
//		TicketWindow tw3 = new TicketWindow();
		
//		Thread t1 = new Thread(tw1);
//		Thread t2 = new Thread(tw2);
//		Thread t3 = new Thread(tw3);
		
		//创建一个窗口
		TicketWindow tw1 = new TicketWindow();
		//使用三个线程同时启动,三个线程共享数据ticketNums
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class TicketWindow  implements Runnable
{
	//票数
	int ticketNums = 200;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//保证原子性
			synchronized (this)//任意对象都可以
			{
				//判断是否还有票
				if(ticketNums > 0)
				{
					//显示售票信息
					//Thread.currentThread().getName()-------->当前线程的名字
					System.out.println(Thread.currentThread().getName() + "正在售出第" + ticketNums + "张票");
					
					//出票速度：1秒出1张
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ticketNums--;
				}
				else
				{
					break;
				}
			}
		}
	}
	
}