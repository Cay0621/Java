package WriterAndReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader:�������������߼���
 * �ص㣺�ܹ������ж�ȡ
 * @author ľʯǰ��Cam
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
