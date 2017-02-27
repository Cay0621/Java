package file;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		for (int i = 0;i < args.length - 1; ++i) {
			FileUtil.fileIn(new File(args[i]), "你好");
			
			FileUtil.mergeFile(new File(args[i]), new File(args[args.length - 1]));
		}
	}

}

class FileUtil{
	public static void fileIn(File file, String text) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(text.getBytes());
		fos.close();
	}
	
	public static void mergeFile(File src, File dest) throws IOException{
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest, true);
		
		int len;
		byte[] buf = new byte[1024];
		while((len = fis.read(buf)) != -1)
			fos.write(buf, 0, len);
		
		fos.close();
		fis.close();
	}
}