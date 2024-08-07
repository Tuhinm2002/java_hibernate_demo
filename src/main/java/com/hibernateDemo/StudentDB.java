package com.hibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Employee")
public class StudentDB {
	
	@Id// Id keyword is for primary key
    private int id;
    private StudentName name;
    
    @OneToOne
    public LaptopDetails laptopDetails;
    
    public LaptopDetails getLaptopDetails() {
		return laptopDetails;
	}

	public void setLaptopDetails(LaptopDetails laptopDetails) {
		this.laptopDetails = laptopDetails;
	}

	@Column(name="fav_color")
    private String color;
    
    @Transient // To ignore any column while creating table
    private String desciption;

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public StudentName getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

	

	
    
    
}
