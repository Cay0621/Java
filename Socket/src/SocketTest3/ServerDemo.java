package SocketTest3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ServerDemo {
	private ServerSocket socket;
	private int port = 8088;
	
	private ExecutorService threadPool;
	
	public ServerDemo(){
		try {
			/**
			 * ServerSocket���췽��Ҫ����Ҫ�򿪵Ķ˿ں�
			 * ServerSocket�����ڴ�����ʱ��������ϵͳ���������˿�
			 */
			socket = new ServerSocket(port);
			//����50���̵߳Ĺ̶��̳߳�
			threadPool = Executors.newFixedThreadPool(50);
			
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
				OutputStream out = socket.getOutputStream();
				
				//��װΪ�����ַ���
				PrintStream writer = new PrintStream(out);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				
				//�����ͻ��˷��͹�������Ϣ
				String info = reader.readLine();//������
				System.out.println(info);
				
				//������Ϣ���ͻ���
				writer.println("��ã��ͻ��ˣ�");
				writer.flush();
				
				info = reader.readLine();//������
				System.out.println(info);
				
				writer.println("�ټ����ͻ��ˣ�");
				writer.flush();
				
				socket.close();//�ر���ͻ��˵�����
				
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
