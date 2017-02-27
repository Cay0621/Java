package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

public class DBCPTest {

	@Test
	public void test() {
		BasicDataSource ds = DBUtil.getDataSource();
		Connection connection = null;
		try {
			connection = ds.getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from user");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}
