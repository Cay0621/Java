package WriterAndReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reader:字符输入流，高级流
 * 
 * @author 木石前盟Cam
 * 
 */
public class InputStreamReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader reader = null;

		try {
			FileInputStream fis = new FileInputStream("write.txt");

			reader = new InputStreamReader(fis);
			
			int d = -1;
			while((d = reader.read()) != -1){
				System.out.println((char)d);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)

					reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
