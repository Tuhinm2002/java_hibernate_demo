package com.hibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LaptopDetails{

	private String laptopName;
	@Id
	private int id;
	
	
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
