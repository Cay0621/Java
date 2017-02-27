package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Java连接数据库 JDBC
 * 
 * @author 木石前盟Cam
 * 
 */

public class JDBCDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		/**
		 * 连接数据库，一定要捕获异常
		 */
		try {
			/**
			 * 与数据库进行连接 分为两步： 
			 * 		1、注册驱动：不同的数据库实现不尽相同，所以要使用不同数据库厂商提供的驱动
			 * 		2、指定数据库位置及用户名和密码进行连接
			 */

			// 1、提供驱动包路径（不同驱动包使用不同的路径名）
			// Oracle
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// MySQL
			Class.forName("com.mysql.jdbc.Driver");

			
			// 2、根据路径，用户名，密码连接数据库
			/**
			 * 路径：不同数据库连接的路径方法不尽相同 
			 * 		如果电脑上已装有数据库，HOST可以使用127.0.0.1或者localhost
			 * 		
			 * 		Oracle:端口号为1521 
			 * 			jdbc:oracle:thin@HOST:PORT:DB_NAME
			 * 
			 * 
			 * 		MySQL:端口号为3306 
			 * 			jdbc:mysql://HOST:PORT/DB_NAME
			 * 	
			 * 用户名： 
			 * 
			 * 密码：
			 * 
			 */
			// Oracle
			/*
			 * Connection conn =
			 * 			DriverManager.getConnection("jdbc:oracle:thin@127.0.0.1:tarena","scott", "tiger");
			 */

			//MySQL
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/test", "root", "Cam20150916");

			if (!conn.isClosed())
				System.out.println("Connecting to MySQL Success...");
			/**
			 * 使用Sql语句来操作数据库 若想执行sql语句，需要使用专门处理sql语句的类Statement
			 */
			state = conn.createStatement();
			String sql = "SELECT * FROM Student";

			// 通过Statement对象executeQuery方法执行sql语句,返回ResultSet结果集
			rs = state.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (state != null)
					state.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
