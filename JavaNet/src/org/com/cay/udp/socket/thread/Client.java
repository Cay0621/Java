package org.com.cay.udp.socket.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		//1、定义服务器的地址，端口号和数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		
		byte[] data = "用户名:admin,密码:123".getBytes();
		
		//2、创建数据报，包含发送的数据信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		//3、创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		
		/**
		 * 接收数据
		 */
		//1、创建数据报， 用于接收服务器端响应的数据
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		//2、接收服务器响应的数据
		socket.receive(packet2);
		
		//3、读取数据
		System.out.println("我是客户端，服务器说: " + (new String(data2, 0, packet2.getLength())));
		
		//4、关闭资源
		socket.close();
		
	}
}
