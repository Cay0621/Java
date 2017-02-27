package WriterAndReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SystemOutTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("你好！！");
		
		PrintStream out = System.out;
		PrintStream fileOut = new PrintStream(new FileOutputStream("SystemOut.txt"));
		
		//将输出流重定向给文件输出流
		System.setOut(fileOut);
		System.out.println("你好！我是输出到文件的！");
		System.setOut(out);
		System.out.println("我是输出到控制台的！");
		
		fileOut.close();
	}

}
