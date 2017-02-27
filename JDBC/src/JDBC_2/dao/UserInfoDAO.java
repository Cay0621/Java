package JDBC_2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import JDBC_2.entity.UserInfo;

/**
 *���û�����в�����DAO 
 * @author ľʯǰ��Cam
 *
 */

/**
 * conn.setAutoCommit(false);//��ֹ�Զ��ύ����
 * 
 * conn.commit();//��ɺ��ύ
 * 
 * conn.rollback();//���ݻع�����δ�ύ֮ǰ���Իع���һ���ύ֮�󣬾��޷��ع���
 * 
 * ������sql��� Statement��һ������addBatch(String sql)����
 * �÷������Խ�������sql����Statement�������б��л��档
 * ��ִ��executeBatch()����ʱ��Statement�Ὣ�����б��л����sql���һ�����ύ�����ݿ⣬ ������Ч�ļ�������ͨ�Ŵ������������ġ�
 * clearBatch()������������б��л��������sql��䡣
 * 
 * PreparedStatementҲ֧��������ԭ����ͬ��ֻ��addBathc()�����������������б����һ��sql��䡣
 * 
 * 
 * @author ľʯǰ��Cam
 *
 */
public class UserInfoDAO extends BaseDAO {

	/**
	 * ����SQL��䳣��
	 */
	private static final String INSERT = "INSERT INTO userinfo VALUES(?,?,?,?,?,?)";

	public boolean saveUserInfo(UserInfo userInfo) {
		Connection conn = null;
		try {
			conn = getConnection();

			PreparedStatement state = conn.prepareStatement(INSERT);

			long start = System.currentTimeMillis();

			String uuid = UUID.randomUUID().toString();

			state.setString(1, uuid);
			state.setString(2, userInfo.getName());
			state.setString(3, userInfo.getPwd());
			state.setInt(4, userInfo.getAge());
			state.setString(5, userInfo.getSex());
			state.setString(6, userInfo.getEmail());

			state.executeUpdate();

			long end = System.currentTimeMillis();
			System.out.println("����ʱ��: " + (end - start) + "����");

			return true;// ִ�гɹ�����true����֪�����߱���ɹ�
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return false;
	}

	/**
	 * ��������������û���Ϣ
	 * 
	 * @param userInfos
	 * @return
	 */
	public boolean saveUserInfos(List<UserInfo> userInfos) {
		Connection conn = null;
		try {
			conn = getConnection();

			conn.setAutoCommit(false);// ��ֹ�Զ��ύ����

			PreparedStatement state = conn.prepareStatement(INSERT);

			long start = System.currentTimeMillis();

			for (UserInfo userInfo : userInfos) {
				String uuid = UUID.randomUUID().toString();

				state.setString(1, uuid);
				state.setString(2, userInfo.getName());
				state.setString(3, userInfo.getPwd());
				state.setInt(4, userInfo.getAge());
				state.setString(5, userInfo.getSex());
				state.setString(6, userInfo.getEmail());

				// δ����addBatch()
				// state.executeUpdate();

				// ����addBatch()
				state.addBatch();
			}
			// ����addBatch()
			state.executeBatch();// ������ִ��֮ǰ���������sql���

			//conn.commit();// ���forѭ���󣬲��ύ�����ݿ�
			
			//��װ���������
			commit();

			long end = System.currentTimeMillis();
			System.out.println("����ʱ��: " + (end - start));

			return true;// ִ�гɹ�����true����֪�����߱���ɹ�
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			rollback();
			
		} finally {
			closeConnection();
		}

		return false;
	}

	// ������
	public void createTable() {
		Connection conn = null;
		Statement state = null;

		try {
			conn = getConnection();
			state = conn.createStatement();

			String sql = "CREATE TABLE userinfo("
					+ "id VARCHAR(36) PRIMARY KEY,"
					+ "name VARCHAR(20) NOT NULL," + "pwd VARCHAR(20),"
					+ "age INT(2)," + "sex VARCHAR(2)," + "email VARCHAR(50)"
					+ ")";

			if (!state.execute(sql)) {
				System.out.println("�������...");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void dropTable() {
		Connection conn = null;
		Statement state = null;

		try {
			conn = getConnection();
			state = conn.createStatement();

			String sql = "DROP TABLE IF EXISTS userinfo";

			if (!state.execute(sql)) {
				System.out.println("ɾ�����...");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public static void main(String[] args) {
		UserInfoDAO dao = new UserInfoDAO();
		dao.createTable();
	}
}
