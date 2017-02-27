package JDBC_1.entity;

import java.io.Serializable;

/**
 * 实体类Student 该类描述数据库中的Student表 其每个实例都可以代表Student表中一条记录（一行数据）
 * 
 * 通常情况下实体都是可以序列化的
 * 
 * @author 木石前盟Cam
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
				+ (sex.equals("1") ? "男" : "女");
	}
}
