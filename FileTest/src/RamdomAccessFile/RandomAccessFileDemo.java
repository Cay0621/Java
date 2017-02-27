package RamdomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("data.bat");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 0x7fffffff;//int中的最大值
		try {
			raf.write(i >>> 24);
			raf.write(i >>> 16);
			raf.write(i >>> 8);
			raf.write(i);
			
			raf.writeInt(Integer.MAX_VALUE);//写int的最大值
			raf.writeLong(Long.MAX_VALUE);//写long的最大值
			
			raf.writeUTF("Hello");//以utf-8编码形式将字符串写入文件中
			
			raf.seek(4);
			int intMax = raf.readInt();
			long longMax = raf.readLong();
			System.out.println(intMax);
			System.out.println(longMax);
			
			String text = raf.readUTF();
			System.out.println(text);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
