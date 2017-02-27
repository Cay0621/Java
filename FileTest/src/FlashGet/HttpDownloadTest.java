package FlashGet;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * �ϵ���������
 * @author ľʯǰ��Cam
 *
 */
public class HttpDownloadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1��������������downloadʵ��
		//2�����������е����ص�ַ���������ӣ���ȡ��Ӧ��������
		//3�����������б����ڱ��ص��ļ��������
		//4�����ж�д���������أ�
		//5���ر���
		
		try{
			FlashGetInfo info = new FlashGetInfo("www.baidu.com/download/11.zip", "11.zip");
			
			//java.net.URL
			URL url = new URL(info.getUrl());
			
			//ͨ����ַ���������ӣ��ͷ�����ͨ�ţ�
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			long totalSize = 
					Long.parseLong(conn.getHeaderField("CONTENT-LENGTH"));
			
			info.setFileSize(totalSize);
			conn.disconnect();//��������Ͽ�
			
			//�ٴ�����
			conn = (HttpURLConnection) url.openConnection();
			/**
			 * Ϊ��ʵ�ֶϵ�������������߷��������ζ�ȡ�ļ��Ŀ�ʼλ�ã��൱�ڱ��ص���seek()
			 * 
			 * �涨��
			 * bytes=0-:	����˼�Ǹ��߷������ӵ�1���ֽڿ�ʼ��ȡ
			 * 				seek(0);
			 * 
			 * bytes=128-��	����˼�Ǹ��߷������ӵ�129���ֽڿ�ʼ��ȡ
			 * 				seek(128);
			 */
			
			String prop = "bytes=" + info.getPos() + "-";
			
			//ͨ���������ò�����֪ͨ��������ʲô�ط���ʼ��ȡ
			conn.setRequestProperty("RANGE", prop);
		
			//����������ʼ��ȡ�ļ�
			InputStream in = conn.getInputStream();
			
			//�������м�¼�ı����ļ���ΪĿ���ļ�
			RandomAccessFile raf = new RandomAccessFile(info.getFileName(), "rw");
			
			//������seek��λ�þ���д��λ��
			raf.seek(info.getPos());
			
			//����������
			byte[] buffer = new byte[1024 * 10];
			int sum = -1;
			
			/**
			 * �������ز���
			 */
			while((sum = in.read(buffer)) > 0){
				raf.write(buffer, 0, sum);
				info.setPos(info.getPos() + sum);
			}
			
			raf.close();
			in.close();
			conn.disconnect();//�رպͷ�����������
			
		}catch(Exception e){
			
		}finally{
			
		}
	}

}
