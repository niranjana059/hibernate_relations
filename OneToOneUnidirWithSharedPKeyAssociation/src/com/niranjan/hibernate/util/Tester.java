package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.AddressDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class Tester {

	public static void main(String[] args) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setStreetName("M S Nagar");
		addressDTO.setCountry("India");
		addressDTO.setZipCode(511156);
		
		employeeDTO.setFirstName("Shankrappa");
		employeeDTO.setLastName("YE");
		employeeDTO.setIncome(900000);
		//employeeDTO.setAddress(addressDTO);
		
		EmployeeDAO dao=new EmployeeDAO();
		dao.createEmployeeAndAddress(employeeDTO, addressDTO);
		
	}

}
