package FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	
	//列出目录下的所有文件
	public static void listDirectory(File dir)	throws IOException{
		
		if(dir == null){
			throw new IllegalArgumentException(dir + "为空！");
		}
		
		if(!dir.exists()){//确定是否存在
			throw new IllegalArgumentException("目录" + dir + "不存在！");
		}
		
		if(!dir.isDirectory()){//查看参数是否为目录
			throw new IllegalArgumentException(dir + "不是个目录！");
		}
		
		File[] files = dir.listFiles();
		if(files != null && files.length > 0){
			for(File f : files){
				if(f.isFile()){//文件
					System.out.println(f.getPath());
				}else{//目录
					listDirectory(f);
				}
			}
		}
	}

	//删除指定目录
	public static void deleteDirectory(File dir)
		throws IOException{
		if(dir == null){
			throw new IllegalArgumentException(dir + "为空！");
		}
		
		if(!dir.exists()){//确定是否存在
			throw new IllegalArgumentException("目录" + dir + "不存在！");
		}
		
		if(!dir.isDirectory()){//查看参数是否为目录
			throw new IllegalArgumentException(dir + "不是个目录！");
		}
		
		File[] files = dir.listFiles();
		if(files != null && files.length > 0){
			for(File f : files){
				if(f.isFile()){
					if(!f.delete()){//查看是否被删除了，可能文件被外部程序占用
						throw new IOException("无法删除文件: " + f);
					}
				}else{
					deleteDirectory(f);
				}
			}
		}
		if(!dir.delete()){//最终删除目录
			throw new IOException("无法删除目录！");
		}
	}
}
