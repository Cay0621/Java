package JDBC_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDAO {
	/*方法1：直接从文件中读取
		final static DataBaseInfo info = JDBCUtils.load("src/config.txt");
		private static String driver = info.getDriver();
		private static String url = info.getUrl();
		private static String user = info.getUserName();
		private static String pwd = info.getPassWord();
	 */
	
	/**
	 * 方法2：java.util.Properties中的Properties类，用于读取.properties文本文件的类
	 * 		文件格式要求必须是key=value的形式，并且以行为单位，一行记录一条数据
	 * 		Properties类方便的读取properties文件，类似HashMap形式读取字符串
	 * 
	 * Properties通常都是当作配置文件而使用的
	 */
	private static Properties properties = new Properties();
	private static String driver = "";
	private static String url = "";
	private static String user = "";
	private static String pwd = "";
	
	/**
	 * 在静态初始化中注册驱动 驱动不需要重复注册，所以静态初始化最合适注册驱动
	 * 
	 */
	static {
		try {
			/**
			 * 加载配置文件，读取配置信息
			 */
			properties.load(BaseDAO.class.getClassLoader()
					.getResourceAsStream("JDBC_1/dao/db.properties"));
			
			//System.out.println(properties.getProperty("mysql.driver"));
			
			/**
			 * 通过Properties的方法getProperty(String key)
			 * 		方法：可以将properties文件中key=value的数据获取
			 */
			driver = properties.getProperty("mysql.driver");
			url = properties.getProperty("mysql.url");
			user = properties.getProperty("mysql.user");
			pwd = properties.getProperty("mysql.pwd");
			
			Class.forName(driver);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pwd);
	}

	/**
	 * 将给定的数据库关闭
	 * 
	 * @param conn
	 */
	protected static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
