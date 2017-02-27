package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JDBCDAO {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src/dao/db.properties"));
			//props.load(JDBCDAO.class.getClassLoader().getResourceAsStream("dao/db.properties"));
			
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		JDBCDAO dao = new JDBCDAO();
		System.out.println("===============");
		System.out.println(dao.user);
	}
	
}
