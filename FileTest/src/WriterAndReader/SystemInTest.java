package WriterAndReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �����̵�������ת��Ϊ�ַ���������ת��Ϊ�����ַ�������
 * @author ľʯǰ��Cam
 *
 */
public class SystemInTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1�������̵��ֽ�������ת��Ϊ�ַ�������
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//2�����ַ�������ת��Ϊ�����ַ�������
		BufferedReader br = new BufferedReader(isr);
		
		//3��ѭ����ȡ����̨������ַ���
		String info = null;
		while(true){
			info = br.readLine();
			if("exit".equals(info)){
				break;
			}
			System.out.println(info);
		}
		
		if(br != null)
			br.close();
	}

}
