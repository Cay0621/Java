package WriterAndReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Writer:字符输出流，高级流
 * 
 * @author 木石前盟Cam
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

			//使用系统默认的编码集输出字符
			writer = new OutputStreamWriter(fos);

			//使用UTF-8编码集输出字符
			//writer = new OutputStreamWriter(fos, "UTF-8");
			
			writer.write("你好！");
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
