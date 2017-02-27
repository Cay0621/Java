package JDBC_1;

import java.util.List;

import JDBC_1.dao.StudentDAO;
import JDBC_1.entity.Student;

public class StudentService {
	private StudentDAO studentDAO = new StudentDAO();

	public void reg(String name, int age, String sex) {
		/**
		 * ��Ҫ����֤ name������Ϊ�ջ��߿��ַ��� age:Ҫ��1-99������ sex��"0"��"1"
		 * 
		 * name�����ظ�
		 */
		if (name == null || name.isEmpty()) {
			System.out.println("�û���Ϊ��!");
			return;
		}
		if (age < 0 || age > 100) {
			System.out.println("���䲻����Ҫ��!");
			return;
		}
		if (!sex.equals("0") && !sex.equals("1")) {
			System.out.println("�Ա��ʶ����!");
			return;
		}

		if (studentDAO.findStudentByName(name) != null) {
			System.out.println("���û��Ѵ���...");
		} else {
			/**
			 * 1�����û��������Ϣת��Ϊһ��Student���� 2�����ö��󽻸�DAO���г־û� 3�����ݱ�����֪ͨ�û�
			 */
			// 1
			Student student = new Student();
			student.setName(name);
			student.setAge(age);
			student.setSex(sex);

			// 2
			if (studentDAO.saveStudent(student)) {
				System.out.println("ע��ɹ���");
			} else {
				System.out.println("ע��ʧ�ܣ�");
			}

		}
	}

	public void findStudentByName(String name) {
		if (name != null && !name.isEmpty()) {
			Student stu = studentDAO.findStudentByName(name);
			if (stu != null) {
				System.out.println("ѧ����" + stu.getName() + ",ѧ�����䣺"
						+ stu.getAge());
			} else {
				System.out.println("���޴���!");
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
