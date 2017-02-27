package FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

	public static byte[] loadBytes(File src) throws IOException {
		if (src == null)
			throw new IllegalArgumentException("文件为空！");

		if (!src.exists())
			throw new IllegalAccessError(src + "文件不存在！");

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(src);

			// FileInputStream的available()返回当前字节输入流可读取的总字节数
			byte[] data = new byte[fis.available()];
			fis.read(data);

			return data;
		} catch (IOException e) {
			throw e;
		} finally {
			fis.close();
		}
	}

	/**
	 * 读取给定的文件，并将数据以字节数组的形式返回
	 * 
	 * @param src
	 * @param data
	 */
	public static void saveBytes(File src, byte[] data) throws IOException {
		
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(src);
			fos.write(data);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			if (fos != null)
				fos.close();
		}
	}

	public static void copyFile1(File src, File dest) {
		if (src == null)
			throw new IllegalArgumentException("文件为空！");
		if (!src.exists())
			throw new IllegalAccessError("文件不存在！");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			
			int data = -1;
			while((data = fis.read()) != -1){
				fos.write(data);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void copyFile2(File src, File dest){
		if(src == null)
			throw new IllegalArgumentException("源文件为空！");
		if(!src.exists())
			throw new IllegalAccessError("源文件不存在！");
		
		
		//创建缓冲流，缓冲流必须依托低级流
		//如果某类流的构造方法要求传入一个流，则这个流类为高级流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			int data = -1;
			while((data = bis.read()) != -1)
				bos.write(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(bis != null)
					bis.close();
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * 使用缓冲字符输入输出流完成文本拷贝
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void copyFile3(File src, File dest) throws IOException{
		FileReader fr = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		fr = new FileReader(src);
		fw = new FileWriter(dest);
		
		br = new BufferedReader(fr);
		bw = new BufferedWriter(fw);
	
		String text = null;
		while((text = br.readLine()) != null){
			bw.write(text + "\r\n");
		}
		
		if(br != null)
			br.close();
		if(bw != null)
			bw.close();
	}
	
	/**
	 * 创建DataOutputStream并处理参数out输出流
	 * @param text
	 * @param out
	 * @throws IOException 
	 */
	public static void saveString(String text, OutputStream out) throws IOException{
		DataOutputStream dos = new DataOutputStream(out);
		
		dos.writeUTF(text);
		
		dos.flush();
		
		//dos.close();
	}
	
	/**
	 * 从输入流in中读取字符串
	 * @param in
	 * @return
	 * @throws IOException 
	 */
	public static String loadString(InputStream in) throws IOException{
		DataInputStream dis = new DataInputStream(in);
		String text = dis.readUTF();
		return text;
	}
}
