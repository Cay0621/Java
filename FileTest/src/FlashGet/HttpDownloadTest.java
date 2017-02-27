package FlashGet;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 断点续传测试
 * @author 木石前盟Cam
 *
 */
public class HttpDownloadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1、创建下载任务，download实例
		//2、根据任务中的下载地址打开网络连接，获取对应的输入流
		//3、创建任务中保存在本地的文件的输出流
		//4、进行读写操作（下载）
		//5、关闭流
		
		try{
			FlashGetInfo info = new FlashGetInfo("www.baidu.com/download/11.zip", "11.zip");
			
			//java.net.URL
			URL url = new URL(info.getUrl());
			
			//通过地址打开网络连接（和服务器通信）
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			long totalSize = 
					Long.parseLong(conn.getHeaderField("CONTENT-LENGTH"));
			
			info.setFileSize(totalSize);
			conn.disconnect();//与服务器断开
			
			//再次连接
			conn = (HttpURLConnection) url.openConnection();
			/**
			 * 为了实现断点续传，必须告诉服务器当次读取文件的开始位置，相当于本地调用seek()
			 * 
			 * 规定：
			 * bytes=0-:	的意思是告诉服务器从第1个字节开始读取
			 * 				seek(0);
			 * 
			 * bytes=128-：	的意思是告诉服务器从第129个字节开始读取
			 * 				seek(128);
			 */
			
			String prop = "bytes=" + info.getPos() + "-";
			
			//通过连接设置参数，通知服务器从什么地方开始读取
			conn.setRequestProperty("RANGE", prop);
		
			//打开输入流开始读取文件
			InputStream in = conn.getInputStream();
			
			//将任务中记录的本地文件作为目标文件
			RandomAccessFile raf = new RandomAccessFile(info.getFileName(), "rw");
			
			//服务器seek的位置就是写的位置
			raf.seek(info.getPos());
			
			//创建缓冲区
			byte[] buffer = new byte[1024 * 10];
			int sum = -1;
			
			/**
			 * 进行下载操作
			 */
			while((sum = in.read(buffer)) > 0){
				raf.write(buffer, 0, sum);
				info.setPos(info.getPos() + sum);
			}
			
			raf.close();
			in.close();
			conn.disconnect();//关闭和服务器的连接
			
		}catch(Exception e){
			
		}finally{
			
		}
	}

}
