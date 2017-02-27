package JDBC_1.entity;

import java.io.Serializable;

/**
 * ʵ����Student �����������ݿ��е�Student�� ��ÿ��ʵ�������Դ���Student����һ����¼��һ�����ݣ�
 * 
 * ͨ�������ʵ�嶼�ǿ������л���
 * 
 * @author ľʯǰ��Cam
 * 
 */
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private int age;
	private String sex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "," + name + "," + age + ","
				+ (sex.equals("1") ? "��" : "Ů");
	}
}
