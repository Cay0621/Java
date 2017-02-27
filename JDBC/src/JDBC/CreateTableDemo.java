package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ʹ��jdbc�����ݿ��в������ݿ��
 * 
 * @author ľʯǰ��Cam
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
				System.out.println("���ӳɹ�...");

			state = conn.createStatement();
			String sql = "CREATE TABLE Student (" +
					"ID VARCHAR(40) PRIMARY KEY," +
					"NAME VARCHAR(20) NOT NULL," +
					"AGE INT," +
					"SEX VARCHAR(2)" +
					")";
			
			/**
			 * execute������ԭ���Ͽ���ִ�������sql���
			 * 
			 * 		false��Ϊ����ɹ��ı�־
			 * 		
			 * ����true����ִ�н��Ϊһ���������ResultSet��
			 * ����false��Ϊ������Ϣ����Ӱ��������������ȣ�
			 * ��������ͨ������ʹ��executeȥִ�в�ѯ���
			 * 
			 */
			if(!state.execute(sql)){
				System.out.println("������ɹ�...");
			}else{
				System.out.println("������ʧ��...");
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
