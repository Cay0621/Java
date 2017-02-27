package WriterAndReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = null;
		
		fr = new FileReader("fileWriter.txt");
		
		
//		//以字符为单位读取文件
//		int d = -1;
//		while((d = fr.read()) != -1){
//			System.out.println((char)d);
//		}
		
		//将文件字符流转换为缓冲字符流，可以以行为单位读取
		BufferedReader br = new BufferedReader(fr);
		String text = null;
		
		while((text = br.readLine()) != null){
			System.out.println(text);
		}
		
		br.close();
		fr.close();
	}

}
