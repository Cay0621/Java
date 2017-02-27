package SerializeObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import FlashGet.FlashGetInfo;//Ϊ��ʹ�����ܹ����л������뽫��ʵ��Serializable�ӿ�

public class SerializeObject {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FlashGetInfo info = new FlashGetInfo("http://www.baidu.com/download/11.zip", "11.zip");
		info.setFileSize(12345);
		info.setPos(473);
		
		File file = new File("obj.tmp");
		FileOutputStream fos = new FileOutputStream(file);
		//�������к�
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(info);
		oos.close();
		
		FileInputStream fis = new FileInputStream(file);
		//�������л�
		ObjectInputStream ois = new ObjectInputStream(fis);
		FlashGetInfo obj = (FlashGetInfo) ois.readObject();
		
		ois.close();
		
		System.out.println(info == obj);//false
		
		System.out.println(obj.getFileName());
		System.out.println(obj.getFileSize());
		System.out.println(obj.getPos());
		System.out.println(obj.getUrl());
	}

}
