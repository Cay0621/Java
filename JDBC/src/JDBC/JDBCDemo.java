package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Java�������ݿ� JDBC
 * 
 * @author ľʯǰ��Cam
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
		 * �������ݿ⣬һ��Ҫ�����쳣
		 */
		try {
			/**
			 * �����ݿ�������� ��Ϊ������ 
			 * 		1��ע����������ͬ�����ݿ�ʵ�ֲ�����ͬ������Ҫʹ�ò�ͬ���ݿ⳧���ṩ������
			 * 		2��ָ�����ݿ�λ�ü��û����������������
			 */

			// 1���ṩ������·������ͬ������ʹ�ò�ͬ��·������
			// Oracle
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			// MySQL
			Class.forName("com.mysql.jdbc.Driver");

			
			// 2������·�����û����������������ݿ�
			/**
			 * ·������ͬ���ݿ����ӵ�·������������ͬ 
			 * 		�����������װ�����ݿ⣬HOST����ʹ��127.0.0.1����localhost
			 * 		
			 * 		Oracle:�˿ں�Ϊ1521 
			 * 			jdbc:oracle:thin@HOST:PORT:DB_NAME
			 * 
			 * 
			 * 		MySQL:�˿ں�Ϊ3306 
			 * 			jdbc:mysql://HOST:PORT/DB_NAME
			 * 	
			 * �û����� 
			 * 
			 * ���룺
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
			 * ʹ��Sql������������ݿ� ����ִ��sql��䣬��Ҫʹ��ר�Ŵ���sql������Statement
			 */
			state = conn.createStatement();
			String sql = "SELECT * FROM Student";

			// ͨ��Statement����executeQuery����ִ��sql���,����ResultSet�����
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
