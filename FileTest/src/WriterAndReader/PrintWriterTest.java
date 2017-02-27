package WriterAndReader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * PrintWriter:缓冲字符输出流
 * 
 * @author 木石前盟Cam
 * 
 */
public class PrintWriterTest {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		PrintWriter pw = new PrintWriter("printwriter.txt");
		
		pw.write("你好！");
		pw.write("Hello world!");
		pw.println();//自动添加换行符
		pw.println("我爱妳");
		
		if(pw != null)
			pw.close();

	}

}
