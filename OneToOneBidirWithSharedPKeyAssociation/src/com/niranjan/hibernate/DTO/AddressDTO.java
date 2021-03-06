package com.niranjan.hibernate.DTO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="address")
public class AddressDTO implements Serializable{

	@Id
	@GenericGenerator(name="f",strategy="foreign",parameters=@Parameter(name="property",value="employee"))
	@GeneratedValue(generator="f")
	@Column(name="address_id")
	private long addressId;

	@Column(name="street_name")
	private String streetName;

	@Column(name="country")
	private String Country;

	@Column(name="zip_code")
	private int zipCode;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EmployeeDTO employee;

	public AddressDTO() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", streetName=" + streetName + ", Country=" + Country
				+ ", zipCode=" + zipCode + ", employee=" + employee + "]";
	}

}
