package WriterAndReader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * PrintWriter:�����ַ������
 * 
 * @author ľʯǰ��Cam
 * 
 */
public class PrintWriterTest {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		PrintWriter pw = new PrintWriter("printwriter.txt");
		
		pw.write("��ã�");
		pw.write("Hello world!");
		pw.println();//�Զ���ӻ��з�
		pw.println("�Ұ���");
		
		if(pw != null)
			pw.close();

	}

}
