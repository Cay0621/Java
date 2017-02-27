package SocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws Exception {
		Socket server = new Socket(InetAddress.getLocalHost(), 5678);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				server.getInputStream()));
		
		PrintWriter out = new PrintWriter(server.getOutputStream());
		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			//从键盘输入
			String str = wt.readLine();
			
			//发送给服务器
			out.println(str);
			out.flush();
			if (str.equals("end")) {
				break;
			}
			//从服务器获取返回的数据
			System.out.println(in.readLine());
		}
		server.close();
	}
}