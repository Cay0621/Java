package SocketTest2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	private ServerSocket socket;
	private int port = 8088;
	
	public ServerDemo(){
		try {
			/**
			 * ServerSocket构造方法要求传入要打开的端口号
			 * ServerSocket对象在创建的时候就向操作系统申请打开这个端口
			 */
			socket = new ServerSocket(port);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 开始服务
	 * 等待接收客户端的请求并与之通信
	 */
	public void start(){
		try {
			/**
			 * 通过调用ServerSocket的accept方法，使服务器开始等待接收客户端的连接
			 * 该方法是一个阻塞方法，监听8088端口是否有客户端来连接
			 * 直到有客户端与其连接，否则该方法不会结束
			 */
			while(true){
				System.out.println("等待客户端连接...");
				Socket s = socket.accept();
				System.out.println("一个客户端连接了，分配线程去接待它...");
				/**
				 * 当一个客户端连接了，就启动一个线程去接待它
				 */
				Thread clientThread = new Thread(new Handler(s));
				clientThread.start();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 定义线程体，该线程的作用是与连接到服务器段的客户端进行交互操作
	 *
	 */
	class Handler implements Runnable{
		
		//当前线程要进行通信的客户端Socket
		private Socket socket;
		
		//通过构造方法将客户端Socket传入
		public Handler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//获取与客户端通信的输入输出流
			InputStream in;
			try {
				in = socket.getInputStream();
			
				OutputStream out = socket.getOutputStream();
				
				//包装为缓冲字符流
				PrintStream writer = new PrintStream(out);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				
				//先听客户端发送过来的信息
				String info = reader.readLine();//会阻塞
				System.out.println(info);
				
				//发送信息给客户端
				writer.println("你好，客户端！");
				writer.flush();
				
				info = reader.readLine();//会阻塞
				System.out.println(info);
				
				writer.println("再见，客户端！");
				writer.flush();
				
				socket.close();//关闭与客户端的连接
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("服务器启动中...");
		ServerDemo demo = new ServerDemo();
		demo.start();
	}
}
