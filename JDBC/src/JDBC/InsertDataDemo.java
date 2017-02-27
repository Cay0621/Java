package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * 使用jdbc向表中插入数据
 * @author 木石前盟Cam
 *
 */
public class InsertDataDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement state = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "Cam20150916");
			if(!conn.isClosed())
				System.out.println("连接数据库成功...");
			
			state = conn.createStatement();
			
			/**
			 * UUID:Universally Unique Identifier------通过唯一标识码
			 * 		对于大数据量的表来说，UUID是存放ID最好的方式
			 * Java提供了支持：
			 * 		UUID.randomUUID().toString()
			 * 		获取一个36位不重复的字符串
			 * 
			 * Oracle提供的支持：
			 * 		函数：sys_guid()
			 * 		获取一个32位不重复的字符串
			 */
			
			String uuid = UUID.randomUUID().toString();//主键
			//System.out.println(uuid);
			String sql = "INSERT INTO Student VALUES('" + uuid + "','Cay',20,'0')";
			
			/**
			 * executeUpdate方法，返回int
			 * 		该返回值为当前执行的sql语句影响数据库的总条数
			 * 		该方法常用于执行insert、update、delete等操作语句
			 */
			
			//查看返回值是否大于0，如果大于0，则执行成功
			if(state.executeUpdate(sql) > 0){
				System.out.println("插入数据成功...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(state != null)
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
