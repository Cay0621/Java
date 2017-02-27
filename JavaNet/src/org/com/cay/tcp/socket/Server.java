package org.com.cay.tcp.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			//1、创建一个服务器Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			
			System.out.println("***服务器启动，等待客户端连接***");
			//2、调用accept()方法开始监听，等待客户端链接
			Socket clientSocket = serverSocket.accept();
			
			//3、获取输入流
			InputStream is = clientSocket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = br.readLine()) != null){
				System.out.println("我是服务端，客户端说: " + info);
			}
			//4、关闭输入流
			clientSocket.shutdownInput();
			
			//5、获取输出流
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
			pw.write("欢迎妳...");
			pw.flush();
			
			//6、关闭资源
			pw.close();
			br.close();
			is.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
