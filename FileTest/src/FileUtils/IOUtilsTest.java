package FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
//			File file = new File("mm.txt");
			//���ļ��ж�ȡ����
//			byte[] data = IOUtils.loadBytes(file);
//			System.out.println(data);
//			
//			//�Ѷ�ȡ�����ݷ�������һ���ļ�
//			File des = new File("bak.txt");
//			IOUtils.saveBytes(des, data);
//			
//			IOUtils.copyFile2(new File("eclipse.zip"), new File("eclipse_copy_2.zip"));
			
			
//			FileOutputStream out = new FileOutputStream("o.txt");
//			
//			IOUtils.saveString("��ð���", out);
//			out.close();
			
			//IOUtils.copyFile3(new File("Source.txt"), new File("Source_copy.txt"));
			IOUtils.copyFile3(new File("eclipse.zip"), new File("eclipse_copy.zip"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
