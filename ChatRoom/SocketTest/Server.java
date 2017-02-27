package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(5678);
		
		Socket client = server.accept();
		System.out.println("Accept one client...");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		
		while (true) {
			//从客户端读取数据
			String str = in.readLine();
			System.out.println(str);
			
			//向客户端发送数据
			out.println("has receive....");
			out.flush();
			if (str.equals("end"))
				break;
		}
		client.close();
	}
}