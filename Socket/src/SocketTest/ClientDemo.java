package SocketTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * �ͻ���
 * 
 * @author ľʯǰ��Cam
 *
 */
public class ClientDemo {
	private Socket socket;
	
	/**
	 * �������Ӳ��������������Ϣ
	 * ���裺
	 * 		1��ͨ���������ĵ�ַ���˿ں������������
	 * 			����Socketʱ��Ҫ������������
	 * 		2�����ӳɹ��󣬿���ͨ��Socket��ȡ�������������
	 * 			ʹ�����������շ������˷��͹�������Ϣ
	 * 			ʹ�����������Ϣ���͸���������
	 * 		3���ر�����
	 */
	public void send(){
		System.out.println("��ʼ���ӷ�����...");
		/**
		 * 1�����ӷ�����
		 * 		һ��Socket��ʵ��������ô���Ϳ���ͨ�������ĵ�ַ�Ͷ˿ں�
		 * 		ȥ�������������������
		 * 		����ĵ�ַ"localhost"�Ƿ������˵ĵ�ַ
		 * 		8088�˿��Ƿ���������Ķ˿�
		 * 		��������Ķ˿���ϵͳ����ģ�����֪��
		 */
		try {
			socket = new Socket("localhost", 8088);
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			/**
			 * ���������ɴ����ַ����Ļ����ַ������
			 */
			PrintStream writer = new PrintStream(out);
			
			writer.println("��ã���������");
			/**
			 * ע�⣬д��������Ļ��������ˣ���û����ķ���������
			 * ����ķ��������;�Ҫ����ʵ��д��������ջ�����
			 */
			writer.flush();
			
			
			/**
			 * ��������ת��Ϊ�����ַ�������
			 */
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			
			/**
			 *	��ȡ���������͹�������Ϣ 
			 */
			String info = reader.readLine();//��ȡ��������Ϣ������
			System.out.println(info);
			
			writer.println("�ټ�����������");
			writer.flush();
			
			info = reader.readLine();
			System.out.println(info);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClientDemo demo = new ClientDemo();
		demo.send();//���ӷ�������ͨ��
	}
}
