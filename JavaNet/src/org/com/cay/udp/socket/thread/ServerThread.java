package org.com.cay.udp.socket.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerThread extends Thread {

	DatagramSocket socket = null;
	DatagramPacket packet = null;

	public ServerThread(DatagramSocket socket, DatagramPacket packet) {
		this.socket = socket;
		this.packet = packet;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 4、读取数据
		byte[] data = packet.getData();
		System.out.println(data);
		
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
		try {
			socket.send(packet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
