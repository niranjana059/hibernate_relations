package com.niranjan.hibernate.util;

import java.util.LinkedHashSet;
import java.util.Set;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.AddressDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class Tester {

	public static void main(String[] args) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		AddressDTO currentAddress = new AddressDTO();		
		currentAddress.setStreetName("b narayanapura");
		currentAddress.setCountry("India");
		currentAddress.setZipCode(5600223);
		
		AddressDTO permanentAddress = new AddressDTO();		
		permanentAddress.setStreetName("Billahalli");
		permanentAddress.setCountry("India");
		permanentAddress.setZipCode(577213);
		
		Set<AddressDTO> addresses=new LinkedHashSet<AddressDTO>();
		addresses.add(currentAddress);
		addresses.add(permanentAddress);
		
		employeeDTO.setFirstName("Niranjan");
		employeeDTO.setLastName("S");
		employeeDTO.setIncome(900000);
		employeeDTO.setAddresses(addresses);
		
		EmployeeDAO dao=new EmployeeDAO();
		dao.createEmployeeAndAddress(employeeDTO, addresses);
		
	}

}
