package WriterAndReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SystemOutTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("��ã���");
		
		PrintStream out = System.out;
		PrintStream fileOut = new PrintStream(new FileOutputStream("SystemOut.txt"));
		
		//��������ض�����ļ������
		System.setOut(fileOut);
		System.out.println("��ã�����������ļ��ģ�");
		System.setOut(out);
		System.out.println("�������������̨�ģ�");
		
		fileOut.close();
	}

}
