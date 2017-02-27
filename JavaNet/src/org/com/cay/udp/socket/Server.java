package org.com.cay.udp.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


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

		// 3、接收客户端发送的数据
		socket.receive(packet);// 此方法在接收到数据之前一直处于阻塞

		// 4、读取数据
		String info = new String(data, 0, packet.getLength());
		System.out.println("我是服务器，客户端说: " + info);

		/**
		 * 服务器发送数据
		 */
		// 1、定义客户端的地址，端口号和数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎妳！".getBytes();

		// 2、创建数据报，包含响应的数据
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);

		// 3、响应客户端
		socket.send(packet2);

		// 4、关闭资源
		socket.close();

	}
}
