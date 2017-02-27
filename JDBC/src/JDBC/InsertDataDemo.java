package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * ʹ��jdbc����в�������
 * @author ľʯǰ��Cam
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
				System.out.println("�������ݿ�ɹ�...");
			
			state = conn.createStatement();
			
			/**
			 * UUID:Universally Unique Identifier------ͨ��Ψһ��ʶ��
			 * 		���ڴ��������ı���˵��UUID�Ǵ��ID��õķ�ʽ
			 * Java�ṩ��֧�֣�
			 * 		UUID.randomUUID().toString()
			 * 		��ȡһ��36λ���ظ����ַ���
			 * 
			 * Oracle�ṩ��֧�֣�
			 * 		������sys_guid()
			 * 		��ȡһ��32λ���ظ����ַ���
			 */
			
			String uuid = UUID.randomUUID().toString();//����
			//System.out.println(uuid);
			String sql = "INSERT INTO Student VALUES('" + uuid + "','Cay',20,'0')";
			
			/**
			 * executeUpdate����������int
			 * 		�÷���ֵΪ��ǰִ�е�sql���Ӱ�����ݿ��������
			 * 		�÷���������ִ��insert��update��delete�Ȳ������
			 */
			
			//�鿴����ֵ�Ƿ����0���������0����ִ�гɹ�
			if(state.executeUpdate(sql) > 0){
				System.out.println("�������ݳɹ�...");
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
