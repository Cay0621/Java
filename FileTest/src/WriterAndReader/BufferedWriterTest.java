package WriterAndReader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * BufferedWriter:������������߼���
 * �ص㣺�ܹ����������
 * @author ľʯǰ��Cam
 *
 */
public class BufferedWriterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		BufferedWriter bw = null;

		try {
			fos = new FileOutputStream("writer.txt");

			// BufferedWriter��֧�ֲ���Ϊ�ֽ����Ĺ��캯������֧�ֲ���ΪWriter������
			bw = new BufferedWriter(new OutputStreamWriter(fos));

			bw.write("��ã�");
			bw.newLine();// ���з�
			bw.write("�ڶ���");
			bw.newLine();
			bw.write("������");
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)

					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
