/*
 * 演示缓冲字符流
 */
package FileTest;

import java.io.*;

public class FileBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		FileReader fr = null;
		FileWriter fw = null;
		
		//先创建一个FileReader对象,
		try {
			fr = new FileReader("Source.txt");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("Dest_1.txt");
			bw = new BufferedWriter(fw);
			
			String s = "";
			
			while((s = br.readLine()) != null)
			{
				s += "\r\n";
				bw.write(s);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
				fr.close();
				
				bw.close();
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
