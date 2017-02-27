package org.com.cay.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PersonForGson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date birthday;
	
	private boolean isSingle;
	
	private List<String> major;
	
	private Car car;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSingle() {
		return isSingle;
	}

	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}

	public List<String> getMajor() {
		return major;
	}

	public void setMajor(List<String> major) {
		this.major = major;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "PersonForGson [name=" + name + ", birthday=" + birthday + ", isSingle=" + isSingle + ", major=" + major
				+ ", car=" + car + "]";
	}
	
	
}
