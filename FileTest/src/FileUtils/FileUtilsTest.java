package FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileUtils.listDirectory(new File("."));
			FileUtils.deleteDirectory(new File("Demo2"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
