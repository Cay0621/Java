package org.com.cay.entity;

import java.io.Serializable;
import java.util.Comparator;

public class Teacher implements Serializable, Comparator<Teacher> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private java.util.Date hiredate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", hiredate=" + hiredate
				+ "]";
	}
	@Override
	public int compare(Teacher o1, Teacher o2) {
		// TODO Auto-generated method stub
		int offset = o1.getAge() - o2.getAge(); 
		if(offset > 0)
			return 1;
		else if(offset < 0)
			return -1;
		else
			return 0;
	}
	
	
}
