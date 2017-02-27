package FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	
	//�г�Ŀ¼�µ������ļ�
	public static void listDirectory(File dir)	throws IOException{
		
		if(dir == null){
			throw new IllegalArgumentException(dir + "Ϊ�գ�");
		}
		
		if(!dir.exists()){//ȷ���Ƿ����
			throw new IllegalArgumentException("Ŀ¼" + dir + "�����ڣ�");
		}
		
		if(!dir.isDirectory()){//�鿴�����Ƿ�ΪĿ¼
			throw new IllegalArgumentException(dir + "���Ǹ�Ŀ¼��");
		}
		
		File[] files = dir.listFiles();
		if(files != null && files.length > 0){
			for(File f : files){
				if(f.isFile()){//�ļ�
					System.out.println(f.getPath());
				}else{//Ŀ¼
					listDirectory(f);
				}
			}
		}
	}

	//ɾ��ָ��Ŀ¼
	public static void deleteDirectory(File dir)
		throws IOException{
		if(dir == null){
			throw new IllegalArgumentException(dir + "Ϊ�գ�");
		}
		
		if(!dir.exists()){//ȷ���Ƿ����
			throw new IllegalArgumentException("Ŀ¼" + dir + "�����ڣ�");
		}
		
		if(!dir.isDirectory()){//�鿴�����Ƿ�ΪĿ¼
			throw new IllegalArgumentException(dir + "���Ǹ�Ŀ¼��");
		}
		
		File[] files = dir.listFiles();
		if(files != null && files.length > 0){
			for(File f : files){
				if(f.isFile()){
					if(!f.delete()){//�鿴�Ƿ�ɾ���ˣ������ļ����ⲿ����ռ��
						throw new IOException("�޷�ɾ���ļ�: " + f);
					}
				}else{
					deleteDirectory(f);
				}
			}
		}
		if(!dir.delete()){//����ɾ��Ŀ¼
			throw new IOException("�޷�ɾ��Ŀ¼��");
		}
	}
}
