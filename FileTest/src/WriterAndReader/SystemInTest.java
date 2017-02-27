package WriterAndReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 将键盘的输入流转换为字符输入流再转换为缓冲字符输入流
 * @author 木石前盟Cam
 *
 */
public class SystemInTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1、将键盘的字节输入流转换为字符输入流
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//2、将字符输入流转换为缓冲字符输入流
		BufferedReader br = new BufferedReader(isr);
		
		//3、循环读取控制台输入的字符串
		String info = null;
		while(true){
			info = br.readLine();
			if("exit".equals(info)){
				break;
			}
			System.out.println(info);
		}
		
		if(br != null)
			br.close();
	}

}
