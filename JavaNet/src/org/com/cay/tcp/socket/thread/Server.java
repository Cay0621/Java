package org.com.cay.tcp.socket.thread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			// 1、创建一个服务器Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);

			int count = 0;
			System.out.println("***服务器启动，等待客户端连接***");
			// 2、调用accept()方法开始监听，等待客户端链接

			Socket clientSocket = null;
			while (true) {

				clientSocket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(clientSocket);
				serverThread.start();

				++count;
				System.out.println("客户端的数量: " + count);
				InetAddress address = clientSocket.getInetAddress();
				System.out.println("客户端的ip地址为: " + address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
