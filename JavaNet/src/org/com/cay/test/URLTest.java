package org.com.cay.test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//创建URL实例
		try {
			URL baidu = new URL("https://www.baidu.com");
			//?后面表示为查询参数，#表示为锚点
			URL baidutieba = new URL(baidu,"/s?wd=java");
			
			System.out.println("协议:" + baidutieba.getProtocol());
			System.out.println("主机:" + baidutieba.getHost());
			
			//如果未指定端口号，则使用默认的端口号，http访问默认使用端口80，
			//而URL类在未指定端口号时，默认将port设为-1，所以此时getPort()方法返回值为-1
			System.out.println("端口:" + baidutieba.getPort());
			
			System.out.println("文件路径:" + baidutieba.getPath());
			System.out.println("文件名:" + baidutieba.getFile());
			System.out.println("相对路径:" + baidutieba.getRef());
			System.out.println("查询字符串:" + baidutieba.getQuery());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
