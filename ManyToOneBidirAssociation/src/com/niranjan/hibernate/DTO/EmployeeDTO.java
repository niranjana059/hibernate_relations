package com.niranjan.hibernate.DTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee")
public class EmployeeDTO implements Serializable{
	@Id
	@GenericGenerator(name="default",strategy="increment")
	@GeneratedValue(generator="default")
	@Column(name="employee_id")
	private long employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="income")
	private double income;
	
	@ManyToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="university_id")
	private UniversityDTO university;
	
	public EmployeeDTO() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public UniversityDTO getUniversity() {
		return university;
	}

	public void setUniversity(UniversityDTO university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", income=" + income + "]";
	}
		
}
