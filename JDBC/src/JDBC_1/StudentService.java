package JDBC_1;

import java.util.List;

import JDBC_1.dao.StudentDAO;
import JDBC_1.entity.Student;

public class StudentService {
	private StudentDAO studentDAO = new StudentDAO();

	public void reg(String name, int age, String sex) {
		/**
		 * 必要的验证 name：不能为空或者空字符串 age:要在1-99的整数 sex："0"或"1"
		 * 
		 * name不能重复
		 */
		if (name == null || name.isEmpty()) {
			System.out.println("用户名为空!");
			return;
		}
		if (age < 0 || age > 100) {
			System.out.println("年龄不符合要求!");
			return;
		}
		if (!sex.equals("0") && !sex.equals("1")) {
			System.out.println("性别标识错误!");
			return;
		}

		if (studentDAO.findStudentByName(name) != null) {
			System.out.println("该用户已存在...");
		} else {
			/**
			 * 1：将用户输入的信息转化为一个Student对象 2：将该对象交给DAO进行持久化 3：根据保存结果通知用户
			 */
			// 1
			Student student = new Student();
			student.setName(name);
			student.setAge(age);
			student.setSex(sex);

			// 2
			if (studentDAO.saveStudent(student)) {
				System.out.println("注册成功！");
			} else {
				System.out.println("注册失败！");
			}

		}
	}

	public void findStudentByName(String name) {
		if (name != null && !name.isEmpty()) {
			Student stu = studentDAO.findStudentByName(name);
			if (stu != null) {
				System.out.println("学生：" + stu.getName() + ",学生年龄："
						+ stu.getAge());
			} else {
				System.out.println("查无此人!");
			}
		}
	}

	public void findAll() {
		List<Student> stuList = studentDAO.findAll();
		if (stuList.size() != 0) {
			for (Student stu : stuList) {
				System.out.println(stu);
			}
		}
	}
}
