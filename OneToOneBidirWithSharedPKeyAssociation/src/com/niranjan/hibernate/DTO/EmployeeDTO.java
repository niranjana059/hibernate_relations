package com.niranjan.hibernate.DTO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee")
public class EmployeeDTO implements Serializable{
	@Id
	@GenericGenerator(name="default",strategy="increment")
	@GeneratedValue(generator="default")
	@Column(name="employee_id")
	private long userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="income")
	private double income;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="employee")
	private AddressDTO address;
	
	public EmployeeDTO() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [userId=" + userId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", income=" + income;
	}

}
