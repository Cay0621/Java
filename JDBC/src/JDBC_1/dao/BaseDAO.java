package JDBC_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDAO {
	/*����1��ֱ�Ӵ��ļ��ж�ȡ
		final static DataBaseInfo info = JDBCUtils.load("src/config.txt");
		private static String driver = info.getDriver();
		private static String url = info.getUrl();
		private static String user = info.getUserName();
		private static String pwd = info.getPassWord();
	 */
	
	/**
	 * ����2��java.util.Properties�е�Properties�࣬���ڶ�ȡ.properties�ı��ļ�����
	 * 		�ļ���ʽҪ�������key=value����ʽ����������Ϊ��λ��һ�м�¼һ������
	 * 		Properties�෽��Ķ�ȡproperties�ļ�������HashMap��ʽ��ȡ�ַ���
	 * 
	 * Propertiesͨ�����ǵ��������ļ���ʹ�õ�
	 */
	private static Properties properties = new Properties();
	private static String driver = "";
	private static String url = "";
	private static String user = "";
	private static String pwd = "";
	
	/**
	 * �ھ�̬��ʼ����ע������ ��������Ҫ�ظ�ע�ᣬ���Ծ�̬��ʼ�������ע������
	 * 
	 */
	static {
		try {
			/**
			 * ���������ļ�����ȡ������Ϣ
			 */
			properties.load(BaseDAO.class.getClassLoader()
					.getResourceAsStream("JDBC_1/dao/db.properties"));
			
			//System.out.println(properties.getProperty("mysql.driver"));
			
			/**
			 * ͨ��Properties�ķ���getProperty(String key)
			 * 		���������Խ�properties�ļ���key=value�����ݻ�ȡ
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
	 * �����������ݿ�ر�
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
