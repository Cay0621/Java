package JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JDBCUtils {
	public static DataBaseInfo load(String configFile){
		DataBaseInfo database = new DataBaseInfo();
		
		FileReader fr = null;
		BufferedReader br = null;
		String text = null;
		
		try {
			fr = new FileReader(configFile);
			br = new BufferedReader(fr);
			
			text = br.readLine();
			String[] info = text.split(",");
			database.setDriver(info[0]);
			database.setUrl(info[1]);
			database.setUserName(info[2]);
			database.setPassWord(info[3]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(br != null)
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return database;
	}
}