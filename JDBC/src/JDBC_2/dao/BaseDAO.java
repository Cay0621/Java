package JDBC_2.dao;

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
	 * ThreadLocal��������ͬһ���߳��в�ͬģ��乲������ʹ�õ�
	 * ThreadLocal�ڲ��򵥣�����ά��һ��HashMap������
	 * 		key��ŵ���ÿһ���̣߳�
	 * 		value�������߳��ڲ�ͬģ���Ҫ���������
	 * 
	 * ÿһ��ThreadLocalʵ����ֻ����һ����������
	 * ��ͬ�߳̿�����Ӧ����ͬһ��ThreadLocalʵ���������ڻ�ȡ���ǲ�ͬ�����ݣ���Ϊ�̼߳䲻����
	 * ÿ���߳��ڲ�ͬģ���й������ݡ�
	 */
	private static ThreadLocal<Connection> localConn 
				= new ThreadLocal<Connection>();
	
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
		/**
		 * ��һ���̵߳��ø÷���Ҫ��ȡ����ʱ���ȼ��֮ǰ����߳��Ƿ��Ѿ���ȡ��һ�������ˣ�
		 * 	���У��Ͳ��ٴ�������
		 */
		Connection conn = localConn.get();//���ڻ�ȡ�̹߳�������
		//���ǿյģ�˵������߳��ǵ�һ�λ�ȡ����
		if(conn == null)
		{
			conn = DriverManager.getConnection(url, user, pwd);
			//�������õ����ӷ����̹߳�����
			localConn.set(conn);//set�����û������̹߳��������
		}
		return conn;
	}

	/**
	 * �����������ݿ�ر�
	 * �ر����ݿ����ӣ���Ҫ�ھ����DAO�����Թر�Connection����
	 * ��ΪBaseDAO�л����������Connection������֪ͨBaseDAO
	 * �������ѱ��رգ���û�취ά�����Connection��
	 * ���п���ʹ��ǰ�̻߳�ȡ��һ���Ѿ��رյ�Connection���ӣ��Ӷ��������ݿ��쳣��
	 * 
	 * @param conn
	 */
	protected static void closeConnection() {
		Connection conn = localConn.get();
		if (conn != null) {
			try {
				conn.close();
				//�ر����ݿ�󣬽������Ӵ��̹߳������Ƴ�
				localConn.remove();
				//localConn.set(null);//ͬ��һ��
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ȥ�̹߳����в鿴��ǰ���ø÷������߳��Ƿ����
	 * Connection ���У����ύ����
	 */
	protected void commit(){
		Connection conn = localConn.get();
		if(conn != null)
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void rollback(){
		Connection conn = localConn.get();
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//��ʼ����
	protected void begin() {
		Connection conn = localConn.get();
		if(conn != null){
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
