package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeInfo")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String mobile_number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", mobile_number=" + mobile_number + "]";
	}
	
	
	
	
}
