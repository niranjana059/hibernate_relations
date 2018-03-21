package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.UniversityDTO;

public class GetTester2 {

	public static void main(String[] args) {
		UniversityDTO udto=new EmployeeDAO().getUniversityDTOById(1);
		new EmployeeDAO().getEmployeesByUniversityDTO(udto);

	}

}
