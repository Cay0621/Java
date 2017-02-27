package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement state = null;
		try {
			DataBaseInfo info = JDBCUtils.load("src/config.txt");
			Class.forName(info.getDriver());
			conn = DriverManager.getConnection(info.getUrl(), info.getUserName(), info.getPassWord());
			if(!conn.isClosed())
				System.out.println("连接数据库成功...");
			
			state = conn.createStatement();
			String sql = "UPDATE Student SET SEX=1 WHERE NAME='Cay'";
			if(state.executeUpdate(sql) > 0){
				System.out.println("修改数据成功...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(state != null)
					state.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
