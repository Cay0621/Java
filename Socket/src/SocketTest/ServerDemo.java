package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
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
		System.out.println("�ȴ��ͻ�������...");
		try {
			/**
			 * ͨ������ServerSocket��accept������ʹ��������ʼ�ȴ����տͻ��˵�����
			 * �÷�����һ����������������8088�˿��Ƿ��пͻ���������
			 * ֱ���пͻ����������ӣ�����÷����������
			 */
			Socket s = socket.accept();
			
			//��ȡ��ͻ���ͨ�ŵ����������
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
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
	
	public static void main(String[] args) {
		System.out.println("������������...");
		ServerDemo demo = new ServerDemo();
		demo.start();
	}
}
