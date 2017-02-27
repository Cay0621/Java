package FileTest;

import java.io.*;

public class FileTest {
	public static void main(String[] args)
	{
//		File f = new File("aa.txt");
		
//		System.out.println(f.exists());
//		System.out.println(f.getAbsolutePath());
//		System.out.println(f.getName());
		
//		File f = new File("bb.txt");//创建文件
//		if(!f.exists())
//		{//不存在
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
//		File f = new File("aa");
//		if(!f.isDirectory())
//		{
//			f.mkdir();
//		}
		
		
		File dir1 = new File("." + File.separator + "Demo1");
		if(!dir1.exists()){
			dir1.mkdir();//mkdir必须要求其父目录存在
		}
		
		//mkdirs可以创建多级目录
		File dir2 = new File("." + File.separator + "Demo2" + File.separator + "A");
		if(!dir2.exists()){
			//dir2.mkdir();//error
			dir2.mkdirs();//ok
		}
		
		
		File file1 = new File(dir2, "aa.txt");
		if(!file1.exists()){
			System.out.println("...");
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//删除目录的时候，要确保目录中的子项全部删除才可以删除目录
		File dir3 = new File("." + File.separator + "Demo2");
		if(dir3.exists()){
			dir3.delete();
		}
		
		
		File f = new File(".");
		if(f.exists() && f.isDirectory())
		{
			File[] files = f.listFiles();
			for(File file : files)
			{
				System.out.println(file.getName());
			}
		}
		
	}
}
