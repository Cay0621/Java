package WriterAndReader;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		
		//File file = new File("fileWriter.txt");
		//fw = new FileWriter(file);

		//Õ¨…œ¡Ωæ‰
		fw = new FileWriter("fileWriter.txt");
		
		fw.write("Hello , world! ");
		
		
		fw.close();
		
	}

}
