package org.com.cay.entity;

import java.io.Serializable;
import java.util.Arrays;

public class PersonForJson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String birthday;
	
	private boolean isSingle;
	
	private String[] major;
	
	private Car car;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean isSingle() {
		return isSingle;
	}

	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}

	public String[] getMajor() {
		return major;
	}

	public void setMajor(String[] major) {
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
		return "PersonForJson [name=" + name + ", birthday=" + birthday + ", isSingle=" + isSingle + ", major="
				+ Arrays.toString(major) + ", car=" + car + "]";
	}
	
	
}
