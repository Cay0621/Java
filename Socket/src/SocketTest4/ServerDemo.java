package SocketTest4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * ����˫������У��ӿ��д���ݲ���
 * ˫������п��Թ涨���д洢Ԫ�صĴ�С
 * һ��������Ԫ�شﵽ���ֵ������������ݵȴ�
 * �ȴ�ʱ���Ǹ����ģ�������ʱ�䵽�ˣ�Ԫ�ػ�δ�л�����ӵĻ������׳���ʱ�쳣
 * 
 * @author ľʯǰ��Cam
 *
 */
public class ServerDemo {
	private ServerSocket socket;
	private int port = 8088;
	
	private ExecutorService threadPool;
	
	private BlockingDeque<String> msgQueue;
	
	public ServerDemo(){
		try {
			/**
			 * ServerSocket���췽��Ҫ����Ҫ�򿪵Ķ˿ں�
			 * ServerSocket�����ڴ�����ʱ��������ϵͳ���������˿�
			 */
			socket = new ServerSocket(port);
			//����50���̵߳Ĺ̶��̳߳�
			threadPool = Executors.newFixedThreadPool(50);
			
			//�����涨��С��˫�������
			//LinkedBlockingDeque��һ�����Բ�ָ�����д�С��˫�������
			//��ָ����С�����ﵽ��ֵ�󣬴���ӵĽ��ȴ������������ֵΪint���ֵ
			msgQueue = new LinkedBlockingDeque<String>(10000);
			
			//������ʱ���������ԵĽ������е�����д���ļ�
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					try {
						//�����������ļ�д��Ϣ�������
						PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true));
						
						//�Ӷ����л�ȡ����Ԫ�أ���д�����
						String msg = null;
						for(int i = 0; i < msgQueue.size(); ++i)
						{
							/**�Ӷ�����ȡ������
							 * ������	
							 * 			0��ʱ����
							 * 			TimeUnit.MILLISECONDS��ʱ�䵥λ
							 */
							msg = msgQueue.poll(0, TimeUnit.MILLISECONDS);
							
							if(msg == null)
								break;
							
							writer.println(msg);//ͨ�������д������
						}
						
						writer.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}, 0, 50);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʼ����
	 * �ȴ����տͻ��˵�������֮ͨ��
	 */
	public void start(){
		try {
			/**
			 * ͨ������ServerSocket��accept������ʹ��������ʼ�ȴ����տͻ��˵�����
			 * �÷�����һ����������������8088�˿��Ƿ��пͻ���������
			 * ֱ���пͻ����������ӣ�����÷����������
			 */
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				Socket s = socket.accept();
				System.out.println("һ���ͻ��������ˣ������߳�ȥ�Ӵ���...");
				/**
				 * ��һ���ͻ��������ˣ�������һ���߳�ȥ�Ӵ���
				 */
//				Thread clientThread = new Thread(new Handler(s));
//				clientThread.start();
				
				/**
				 * ���߳��壨���������񣩽����̳߳�
				 * �̳߳ػ��Զ�������������һ�����е��߳�ȥִ��
				 */
				threadPool.execute(new Handler(s));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �����߳��壬���̵߳������������ӵ��������εĿͻ��˽��н�������
	 *
	 */
	class Handler implements Runnable{
		
		//��ǰ�߳�Ҫ����ͨ�ŵĿͻ���Socket
		private Socket socket;
		
		//ͨ�����췽�����ͻ���Socket����
		public Handler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//��ȡ��ͻ���ͨ�ŵ����������
			try {
				InputStream in = socket.getInputStream();
				
				//��װΪ�����ַ���
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				
				//�����ͻ��˷��͹�������Ϣ
				String info = null;
				boolean b = false;
				while(true)
				{
					info = reader.readLine();//������
					if(info != null)
						/**
						 * ������гɹ�����true�����򷵻�false
						 * �÷����������̣߳����жϻᱨ��
						 */
						b = msgQueue.offer(info, 5, TimeUnit.SECONDS);
					//System.out.println(b);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("������������...");
		ServerDemo demo = new ServerDemo();
		demo.start();
	}
}
