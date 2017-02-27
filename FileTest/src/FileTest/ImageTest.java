/*
 * 图片拷贝
 */
package FileTest;

import java.io.*;

public class ImageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//思路：先把图片读入到内存---》写入到某个文件
		//因为图片是二进制文件，因此只能使用字节流完成
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("a.jpg");
			fos = new FileOutputStream("b.jpg");
			
			byte buf[] = new byte[fis.available()];
			int n = 0;
			while((n = fis.read(buf)) != -1)
			{
				//输出到指定文件
				fos.write(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
