package org.com.cay.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {

	public static void main(String[] args) {
		//创建一个URL实例
		try {
			URL url = new URL("http://www.baidu.com");
	
			InputStream is = url.openStream();
			
			//将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			//为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			
			String data = br.readLine();
			while(data != null){
				System.out.println(data);
				data = br.readLine();
			}
			
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
