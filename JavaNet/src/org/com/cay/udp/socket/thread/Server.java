package org.com.cay.udp.socket.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	public static void main(String[] args) throws IOException {
		/**
		 * 服务器端接收数据
		 */
		// 1、创建服务器端DatagramSocket，指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		// 2、创建数据报，用于接收客户端发送的数据
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);

		System.out.println("***服务器端已启动，等待客户端连***");
		
		while(true){
			// 3、接收客户端发送的数据
			socket.receive(packet);// 此方法在接收到数据之前一直处于阻塞
			
//			System.out.println(packet.getLength());
//			System.out.println(new String(packet.getData()));
			
			new ServerThread(socket,packet).start();
		}
		
		
	}
}
