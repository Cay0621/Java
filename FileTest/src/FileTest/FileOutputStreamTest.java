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
				fos = new FileOutputStream(f);//������ļ�����
				//fos = new FileOutputStream(f, true);//�ڶ�������Ϊboolean�������Ƿ�׷��
				
				String s1 = "Hello world,";
				String s2 = "���!";
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
