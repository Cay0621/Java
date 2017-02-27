package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryDataDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement state = null;
		DataBaseInfo info = JDBCUtils.load("src/config.txt");
		//System.out.println(info.getUserName() + "," + info.getPassWord());
		try {
			Class.forName(info.getDriver());
			conn = DriverManager.getConnection(info.getUrl(), 
					info.getUserName(), info.getPassWord());
			
			state = conn.createStatement();
			String sql = "SELECT * FROM student";
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()){
				String id = rs.getString(1);//µÈ¼Ûrs.getString("ID");
				String name = rs.getString(2);//rs.getString("NAME");
				int age = rs.getInt(3);//rs.getInt("AGE");
				String sex = rs.getString(4).equals("1") ? "ÄÐ" : "Å®";//rs.getString("SEX").
				System.out.println(id + "," + name + "," + age + "," + sex);
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
