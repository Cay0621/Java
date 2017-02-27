package WriterAndReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Writer:�ַ���������߼���
 * 
 * @author ľʯǰ��Cam
 * 
 */
public class OutputStreamWriterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		OutputStreamWriter writer = null;
		try {
			fos = new FileOutputStream("write.txt");

			//ʹ��ϵͳĬ�ϵı��뼯����ַ�
			writer = new OutputStreamWriter(fos);

			//ʹ��UTF-8���뼯����ַ�
			//writer = new OutputStreamWriter(fos, "UTF-8");
			
			writer.write("��ã�");
			writer.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(writer != null)
					writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
