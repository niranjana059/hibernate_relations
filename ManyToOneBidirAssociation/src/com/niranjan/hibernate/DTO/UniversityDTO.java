package com.niranjan.hibernate.DTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="university")
public class UniversityDTO implements Serializable{

	@Id
	@GenericGenerator(name="default",strategy="increment")
	@GeneratedValue(generator="default")
	@Column(name="university_id")
	private long universityId;

	@Column(name="country")
	private String Country;

	@Column(name="zip_code")
	private int zipCode;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="university")
	private Set<EmployeeDTO> employees;
	
	public UniversityDTO() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}

	public long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(long universityId) {
		this.universityId = universityId;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "UniversityDTO [universityId=" + universityId + ", Country=" + Country + ", zipCode=" + zipCode
				+ ", employees=" + employees + "]";
	}

	public Set<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeDTO> employees) {
		this.employees = employees;
	}
}
