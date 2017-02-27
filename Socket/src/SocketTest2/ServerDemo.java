package SocketTest2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	private ServerSocket socket;
	private int port = 8088;
	
	public ServerDemo(){
		try {
			/**
			 * ServerSocket���췽��Ҫ����Ҫ�򿪵Ķ˿ں�
			 * ServerSocket�����ڴ�����ʱ��������ϵͳ���������˿�
			 */
			socket = new ServerSocket(port);
			
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
				Thread clientThread = new Thread(new Handler(s));
				clientThread.start();
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
			InputStream in;
			try {
				in = socket.getInputStream();
			
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
