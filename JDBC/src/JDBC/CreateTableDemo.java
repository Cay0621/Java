package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用jdbc向数据库中插入数据库表
 * 
 * @author 木石前盟Cam
 *
 */
public class CreateTableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement state = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/test", "root", "Cam20150916");
			if (!conn.isClosed())
				System.out.println("连接成功...");

			state = conn.createStatement();
			String sql = "CREATE TABLE Student (" +
					"ID VARCHAR(40) PRIMARY KEY," +
					"NAME VARCHAR(20) NOT NULL," +
					"AGE INT," +
					"SEX VARCHAR(2)" +
					")";
			
			/**
			 * execute方法：原则上可以执行任意的sql语句
			 * 
			 * 		false：为建表成功的标志
			 * 		
			 * 返回true：若执行结果为一个结果集（ResultSet）
			 * 返回false：为其他信息（如影响表数据总条数等）
			 * 所以我们通常不会使用execute去执行查询语句
			 * 
			 */
			if(!state.execute(sql)){
				System.out.println("创建表成功...");
			}else{
				System.out.println("创建表失败...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
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
