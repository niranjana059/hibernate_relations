package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.AddressDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class Tester {

	public static void main(String[] args) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setStreetName("B Narayanapura");
		addressDTO.setCountry("India");
		addressDTO.setZipCode(560067);
		
		employeeDTO.setFirstName("Niranjan");
		employeeDTO.setLastName("S");
		employeeDTO.setIncome(400000);
		employeeDTO.setAddress(addressDTO);
		addressDTO.setEmployee(employeeDTO);
		
		EmployeeDAO dao=new EmployeeDAO();
		dao.createEmployeeAndAddress(employeeDTO, addressDTO);
		
	}

}
