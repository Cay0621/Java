package FileTest;

import java.io.*;

public class FileInputStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("Source.txt");
		FileInputStream fis = null;
		
		if(f.exists())
		{
			try {
		
				fis = new FileInputStream(f);
				byte[] bytes = new byte[1024]; 
				int n = 0;
				
				while((n = fis.read(bytes)) != -1)
				{
					//把字节转化为String
					String s = new String(bytes,0,n);
					System.out.println(s);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println("不存在");
		}
		
	}

}
