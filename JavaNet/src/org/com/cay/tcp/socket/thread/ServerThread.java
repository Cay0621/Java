package org.com.cay.tcp.socket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 3、获取输入流
		InputStream is = null;
		BufferedReader br = null;
		// 5、获取输出流
		PrintWriter pw = null;

		try {
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务端，客户端说: " + info);
			}
			// 4、关闭输入流
			socket.shutdownInput();

			pw = new PrintWriter(socket.getOutputStream());
			pw.write("欢迎妳...");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6、关闭资源
			try {
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
