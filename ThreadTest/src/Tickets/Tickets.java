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
		
		//����һ������
		TicketWindow tw1 = new TicketWindow();
		//ʹ�������߳�ͬʱ����,�����̹߳�������ticketNums
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
	//Ʊ��
	int ticketNums = 200;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//��֤ԭ����
			synchronized (this)//������󶼿���
			{
				//�ж��Ƿ���Ʊ
				if(ticketNums > 0)
				{
					//��ʾ��Ʊ��Ϣ
					//Thread.currentThread().getName()-------->��ǰ�̵߳�����
					System.out.println(Thread.currentThread().getName() + "�����۳���" + ticketNums + "��Ʊ");
					
					//��Ʊ�ٶȣ�1���1��
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