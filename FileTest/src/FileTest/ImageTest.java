/*
 * ͼƬ����
 */
package FileTest;

import java.io.*;

public class ImageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//˼·���Ȱ�ͼƬ���뵽�ڴ�---��д�뵽ĳ���ļ�
		//��ΪͼƬ�Ƕ������ļ������ֻ��ʹ���ֽ������
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("a.jpg");
			fos = new FileOutputStream("b.jpg");
			
			byte buf[] = new byte[fis.available()];
			int n = 0;
			while((n = fis.read(buf)) != -1)
			{
				//�����ָ���ļ�
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
