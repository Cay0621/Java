package SocketTest4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 加入双缓冲队列，加快读写数据操作
 * 双缓冲队列可以规定队列存储元素的大小
 * 一旦队列中元素达到最大值，待插入的数据等待
 * 等待时间是给定的，当给定时间到了，元素还未有机会入队的话，就抛出超时异常
 * 
 * @author 木石前盟Cam
 *
 */
public class ServerDemo {
	private ServerSocket socket;
	private int port = 8088;
	
	private ExecutorService threadPool;
	
	private BlockingDeque<String> msgQueue;
	
	public ServerDemo(){
		try {
			/**
			 * ServerSocket构造方法要求传入要打开的端口号
			 * ServerSocket对象在创建的时候就向操作系统申请打开这个端口
			 */
			socket = new ServerSocket(port);
			//创建50个线程的固定线程池
			threadPool = Executors.newFixedThreadPool(50);
			
			//创建规定大小的双缓冲队列
			//LinkedBlockingDeque是一个可以不指定队列大小的双缓冲队列
			//若指定大小，当达到峰值后，待入队的将等待，理论上最大值为int最大值
			msgQueue = new LinkedBlockingDeque<String>(10000);
			
			//创建定时器，周期性的将队列中的数据写入文件
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					try {
						//创建用于向文件写信息的输出流
						PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true));
						
						//从队列中获取所有元素，做写入操作
						String msg = null;
						for(int i = 0; i < msgQueue.size(); ++i)
						{
							/**从队列中取出数据
							 * 参数：	
							 * 			0：时间量
							 * 			TimeUnit.MILLISECONDS：时间单位
							 */
							msg = msgQueue.poll(0, TimeUnit.MILLISECONDS);
							
							if(msg == null)
								break;
							
							writer.println(msg);//通过输出流写出数据
						}
						
						writer.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}, 0, 50);
			
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
//				Thread clientThread = new Thread(new Handler(s));
//				clientThread.start();
				
				/**
				 * 将线程体（并发的任务）交给线程池
				 * 线程池会自动将该任务分配给一个空闲的线程去执行
				 */
				threadPool.execute(new Handler(s));
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
			try {
				InputStream in = socket.getInputStream();
				
				//包装为缓冲字符流
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				
				//先听客户端发送过来的信息
				String info = null;
				boolean b = false;
				while(true)
				{
					info = reader.readLine();//会阻塞
					if(info != null)
						/**
						 * 插入队列成功返回true，否则返回false
						 * 该方法会阻塞线程，若中断会报错！
						 */
						b = msgQueue.offer(info, 5, TimeUnit.SECONDS);
					//System.out.println(b);
				}
				
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
