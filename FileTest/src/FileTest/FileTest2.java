/*
 * 演示文件字符流
 */
package FileTest;

import java.io.*;

public class FileTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Source.txt");
			fw = new FileWriter("Dest.txt");
			
			char[] buf = new char[1024];
			int n = 0;
			while((n = fr.read(buf)) != -1)
			{
				fw.write(buf, 0, n);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
