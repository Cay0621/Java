package JDBC_2.dao;

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
	 * ThreadLocal是用于在同一个线程中不同模块间共享数据使用的
	 * ThreadLocal内部简单，就是维护一个HashMap，其中
	 * 		key存放的是每一个线程，
	 * 		value存放这个线程在不同模块间要共享的数据
	 * 
	 * 每一个ThreadLocal实例，只保存一个共享数据
	 * 不同线程看到的应该是同一个ThreadLocal实例，但是在获取的是不同的数据，因为线程间不共享，
	 * 每个线程在不同模块中共享数据。
	 */
	private static ThreadLocal<Connection> localConn 
				= new ThreadLocal<Connection>();
	
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
		/**
		 * 当一个线程调用该方法要获取连接时，先检查之前这个线程是否已经获取过一个连接了，
		 * 	若有，就不再创建连接
		 */
		Connection conn = localConn.get();//用于获取线程共享数据
		//若是空的，说明这个线程是第一次获取连接
		if(conn == null)
		{
			conn = DriverManager.getConnection(url, user, pwd);
			//将创建好的连接放入线程共享中
			localConn.set(conn);//set方法用户保存线程共享的数据
		}
		return conn;
	}

	/**
	 * 将给定的数据库关闭
	 * 关闭数据库连接，不要在具体的DAO中擅自关闭Connection连接
	 * 因为BaseDAO中还保留着这个Connection，若不通知BaseDAO
	 * 该连接已被关闭，就没办法维护这个Connection了
	 * 这有可能使当前线程获取到一个已经关闭的Connection连接，从而导致数据库异常！
	 * 
	 * @param conn
	 */
	protected static void closeConnection() {
		Connection conn = localConn.get();
		if (conn != null) {
			try {
				conn.close();
				//关闭数据库后，将该连接从线程共享中移除
				localConn.remove();
				//localConn.set(null);//同上一句
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 先去线程共享中查看当前调用该方法的线程是否共享过
	 * Connection 若有，就提交事务
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
	
	//开始事务
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
