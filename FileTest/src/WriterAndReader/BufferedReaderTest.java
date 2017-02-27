package WriterAndReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader:缓冲输入流，高级流
 * 特点：能够以整行读取
 * @author 木石前盟Cam
 *
 */
public class BufferedReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream("writer.txt");
			
			br = new BufferedReader(new InputStreamReader(fis));
			String text;
			while((text = br.readLine()) != null){
				System.out.println(text);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			if(br != null)
				
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
