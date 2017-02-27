package FileFilterDemo;

import java.io.File;
import java.io.FileFilter;

public class FileFilterClass {
	
	public static void main(String[] args) {
		
		FileFilter fileFilter = new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.getName().endsWith(".java");
			}
		};
		
		File file = new File(".");
		File[] files = file.listFiles(fileFilter);
		for(File f : files){
			System.out.println(f);
		}
	}
	
}
