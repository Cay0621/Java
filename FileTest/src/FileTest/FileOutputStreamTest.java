package FileTest;

import java.io.*;
import java.nio.charset.Charset;

public class FileOutputStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("ss.txt");
		FileOutputStream fos = null;
		
		if(!f.exists())
		{
			try {
				//f.createNewFile();
				fos = new FileOutputStream(f);//会清空文件内容
				//fos = new FileOutputStream(f, true);//第二个参数为boolean，代表是否追加
				
				String s1 = "Hello world,";
				String s2 = "你好!";
				fos.write(s1.getBytes());
				fos.write(s2.getBytes(Charset.forName("UTF-8")));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
