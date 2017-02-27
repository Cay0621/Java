package RamdomAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyFile {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			CopyFileByOneByte("Source.txt");
			
			CopyFileByBuffer("eclipse.zip");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void CopyFileByOneByte(String fileName) throws IOException{
		File srcFile = new File(fileName);
		RandomAccessFile src = new RandomAccessFile(srcFile, "r");
		
		String destFileName;
		String[] str = fileName.split("\\.");
		
		if(str.length > 1){//有后缀名
			destFileName = str[0] + "_copy." + str[1];
		}else{//无后缀名
			destFileName = fileName + "_copy";
		}

		File destFile = new File(destFileName);
		destFile.createNewFile();// 创建复制文件
		RandomAccessFile dest = new RandomAccessFile(destFile, "rw");

		// 开始读文件,一个一个字节读取
		int data = 0;
		while ((data = src.read()) != -1) {
			dest.write(data);
		}
		
		src.close();
		dest.close();
	}
	
	public static void CopyFileByBuffer(String fileName) throws IOException{
		File srcFile = new File(fileName);
		RandomAccessFile src = new RandomAccessFile(srcFile, "r");
		//RandomAccessFile src = new RandomAccessFile(fileName, "r");//两句并为一句
		
		String destFileName;
		String[] str = fileName.split("\\.");
		
		if(str.length > 1){//有后缀名
			destFileName = str[0] + "_copy." + str[1];
		}else{//无后缀名
			destFileName = fileName + "_copy";
		}

		File destFile = new File(destFileName);
		if(destFile.exists())//存在的话先删除
			destFile.delete();
		
		destFile.createNewFile();// 创建复制文件
		RandomAccessFile dest = new RandomAccessFile(destFile, "rw");

		// 开始读文件，利用缓冲区
		byte[] buff = new byte[1024 * 100];//100k
		int sum = 0;
		while((sum = src.read(buff)) > 0){
			dest.write(buff, 0, sum);
		}
		
		src.close();
		dest.close();
	}

}
