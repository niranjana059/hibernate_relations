package com.niranjan.hibernate.util;

import java.util.LinkedHashSet;
import java.util.Set;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.UniversityDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class Tester {

	public static void main(String[] args) {
		UniversityDTO universityDTO=new  UniversityDTO();
		universityDTO.setCountry("India");
		universityDTO.setZipCode(11112);
		
		EmployeeDTO employeeDTO1= new EmployeeDTO();
		employeeDTO1.setFirstName("Rakesh");
		employeeDTO1.setLastName("s");
		employeeDTO1.setIncome(200000);
		employeeDTO1.setUniversity(universityDTO);
		
		EmployeeDTO employeeDTO2= new EmployeeDTO();
		employeeDTO2.setFirstName("Ashwin");
		employeeDTO2.setLastName("Kumar");
		employeeDTO2.setIncome(600000);
		employeeDTO2.setUniversity(universityDTO);
		
		
		EmployeeDTO employeeDTO3= new EmployeeDTO();
		employeeDTO3.setFirstName("Santhu");
		employeeDTO3.setLastName("NN");
		employeeDTO3.setIncome(9000000);
		employeeDTO3.setUniversity(universityDTO);
		
		Set<EmployeeDTO> employees=new LinkedHashSet<EmployeeDTO>();
		employees.add(employeeDTO1);
		employees.add(employeeDTO2);
		employees.add(employeeDTO3);
		
		EmployeeDAO dao=new EmployeeDAO();
		dao.createEmployeeAndAddress(employees, universityDTO);
		
	}

}
