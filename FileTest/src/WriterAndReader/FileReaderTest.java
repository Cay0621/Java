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
		
		
//		//���ַ�Ϊ��λ��ȡ�ļ�
//		int d = -1;
//		while((d = fr.read()) != -1){
//			System.out.println((char)d);
//		}
		
		//���ļ��ַ���ת��Ϊ�����ַ�������������Ϊ��λ��ȡ
		BufferedReader br = new BufferedReader(fr);
		String text = null;
		
		while((text = br.readLine()) != null){
			System.out.println(text);
		}
		
		br.close();
		fr.close();
	}

}
