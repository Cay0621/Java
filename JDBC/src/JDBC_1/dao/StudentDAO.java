package JDBC_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import JDBC.DataBaseInfo;
import JDBC.JDBCUtils;
import JDBC_1.entity.Student;

/**
 * DAO�������Ӷ���
 * 
 * StudentDAO���ڲ������ݿ�Student��
 * 
 * @author ľʯǰ��Cam
 * 
 */
public class StudentDAO extends BaseDAO {
	public Student findStudentByName(String name) {
		Connection conn = null;
		//Statement state = null;
		ResultSet rs = null;

		try {
			// ���ø�������ӷ���
			conn = getConnection();

			//state = conn.createStatement();
			//String sql = "SELECT * FROM Student WHERE name='" + name + "'";
			//rs = state.executeQuery(sql);
			
			//ʹ��PreparedStatement
			String sql = "SELECT * FROM Student WHERE name=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, name);
			rs = state.executeQuery();
			
			if (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getString("sex"));
				return stu;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// ���ø���Ĺر����ӷ���
			closeConnection(conn);
		}
		return null;
	}

	public boolean saveStudent(Student stu) {
		Connection conn = null;
		//Statement state = null;

		try {
			conn = getConnection();

			//state = conn.createStatement();
			String uuid = UUID.randomUUID().toString();
			
			/**
			 * Statement��ȱ�㣺
			 * 		1��ά���������ѣ���дsql��临��
			 * 		2��Statementÿ��ִ��sql���ʱ��Ҫ�ڴ���ǰ���룬Ч�ʵ�
			 * 		3������ȫ�����ܳ���sqlע�빥��
			 * 
			 */
			
//			String sql = "INSERT INTO Student VALUES('" + uuid + "','"
//					+ stu.getName() + "'," + stu.getAge() + ",'" + stu.getSex()
//					+ "')";
//			System.out.println(sql);
//			if (state.executeUpdate(sql) > 0) {
//				return true;
//			}
			
			/**PreparedStatement
			 * Ԥ����sql��䣬����̬�仯������ʹ��"?"���棬Ȼ���ù�PreparedStatement��
			 * ִ�и�sqlʱͨ�������Ĳ�������?���ﵽ���벻ͬ���ݵ�Ŀ��
			 * Ԥ����sql����һ����ʽ����ģ��
			 */
			String sql = "INSERT INTO Student VALUES(?,?,?,?)";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, uuid);
			state.setString(2, stu.getName());
			state.setInt(3, stu.getAge());
			state.setString(4, stu.getSex());

			/*
			 * PreparedStatementҲ��execute(),executeQuery()��executeUpdate()������ֻ���������޲ε�
			 * ��Ϊ�ڻ�ȡPreparedStatement��ʱ���Ѿ���sql��䴫���ˣ�������ִ�е�ʱ�򣬲���Ҫ����sql
			 * 
			 */
			if (state.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}
		return false;
	}

	public List<Student> findAll() {
		List<Student> stuList = new ArrayList<Student>();
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			state = conn.createStatement();
			String sql = "SELECT * FROM Student";

			rs = state.executeQuery(sql);

			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getString("sex"));
				stuList.add(stu);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(conn);
		}

		return stuList;
	}

}
