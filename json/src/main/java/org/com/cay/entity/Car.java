package org.com.cay.entity;

import java.io.Serializable;

public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;
	private String name;
	private int price;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", name=" + name + ", price=" + price + "]";
	}

	public Car(String color, String name, int price) {
		super();
		this.color = color;
		this.name = name;
		this.price = price;
	}

	public Car() {
		super();
	}

}
