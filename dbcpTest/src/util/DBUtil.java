package util;

import java.util.Properties;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBUtil {

	private static BasicDataSource ds = null;
	static{
		try {
			Properties prop = new Properties();
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			System.out.println(prop.getProperty("jdbc.url"));
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BasicDataSource getDataSource(){
		return ds;
	}
}
