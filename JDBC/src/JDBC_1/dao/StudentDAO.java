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
 * DAO数据连接对象
 * 
 * StudentDAO用于操作数据库Student表
 * 
 * @author 木石前盟Cam
 * 
 */
public class StudentDAO extends BaseDAO {
	public Student findStudentByName(String name) {
		Connection conn = null;
		//Statement state = null;
		ResultSet rs = null;

		try {
			// 调用父类的连接方法
			conn = getConnection();

			//state = conn.createStatement();
			//String sql = "SELECT * FROM Student WHERE name='" + name + "'";
			//rs = state.executeQuery(sql);
			
			//使用PreparedStatement
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
			// 调用父类的关闭连接方法
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
			 * Statement的缺点：
			 * 		1、维护代码困难，编写sql语句复杂
			 * 		2、Statement每次执行sql语句时都要在传送前编译，效率低
			 * 		3、不安全，可能出现sql注入攻击
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
			 * 预编译sql语句，将动态变化的数据使用"?"代替，然后用过PreparedStatement类
			 * 执行该sql时通过给定的参数代替?来达到插入不同数据的目的
			 * 预编译sql更像一个格式或者模版
			 */
			String sql = "INSERT INTO Student VALUES(?,?,?,?)";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, uuid);
			state.setString(2, stu.getName());
			state.setInt(3, stu.getAge());
			state.setString(4, stu.getSex());

			/*
			 * PreparedStatement也有execute(),executeQuery()和executeUpdate()方法，只不过都是无参的
			 * 因为在获取PreparedStatement的时候已经将sql语句传入了，所以在执行的时候，不需要传入sql
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
