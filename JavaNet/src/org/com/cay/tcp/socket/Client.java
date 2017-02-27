package org.com.cay.tcp.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			//1、创建客户端Socket，指定服务器的ip地址和端口
			Socket socket = new Socket("127.0.0.1",8888);
			
			//2、获取输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名：admin，密码：123");
			pw.flush();
			
			socket.shutdownOutput();
			
			//3、获取输入流,并读取服务器的响应信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String info = null;
			while((info = br.readLine()) != null){
				System.out.println("我是客户端，服务端说: " + info);
			}
			
			
			pw.close(); 
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
