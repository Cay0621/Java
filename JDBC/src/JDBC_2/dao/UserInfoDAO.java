package JDBC_2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import JDBC_2.entity.UserInfo;

/**
 *对用户表进行操作的DAO 
 * @author 木石前盟Cam
 *
 */

/**
 * conn.setAutoCommit(false);//禁止自动提交事务
 * 
 * conn.commit();//完成后提交
 * 
 * conn.rollback();//数据回滚，在未提交之前可以回滚，一旦提交之后，就无法回滚了
 * 
 * 批处理sql语句 Statement的一个方法addBatch(String sql)方法
 * 该方法可以将给定的sql存入Statement的命令列表中缓存。
 * 当执行executeBatch()方法时，Statement会将命令列表中缓存的sql语句一次性提交给数据库， 可以有效的减少网络通信带来的性能消耗。
 * clearBatch()用于清空命令列表中缓存的所有sql语句。
 * 
 * PreparedStatement也支持批处理，原理相同，只是addBathc()不带参数，向命令列表添加一条sql语句。
 * 
 * 
 * @author 木石前盟Cam
 *
 */
public class UserInfoDAO extends BaseDAO {

	/**
	 * 定义SQL语句常量
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
			System.out.println("所耗时间: " + (end - start) + "毫秒");

			return true;// 执行成功返回true，告知调用者保存成功
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return false;
	}

	/**
	 * 保存给定的所有用户信息
	 * 
	 * @param userInfos
	 * @return
	 */
	public boolean saveUserInfos(List<UserInfo> userInfos) {
		Connection conn = null;
		try {
			conn = getConnection();

			conn.setAutoCommit(false);// 禁止自动提交事务

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

				// 未加入addBatch()
				// state.executeUpdate();

				// 加入addBatch()
				state.addBatch();
			}
			// 加入addBatch()
			state.executeBatch();// 批处理执行之前缓存的所有sql语句

			//conn.commit();// 完成for循环后，才提交给数据库
			
			//封装后的事务处理
			commit();

			long end = System.currentTimeMillis();
			System.out.println("所耗时间: " + (end - start));

			return true;// 执行成功返回true，告知调用者保存成功
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			rollback();
			
		} finally {
			closeConnection();
		}

		return false;
	}

	// 创建表
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
				System.out.println("创建完成...");
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
				System.out.println("删除完成...");
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
