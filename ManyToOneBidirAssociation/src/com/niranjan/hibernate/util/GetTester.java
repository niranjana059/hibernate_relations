package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.UniversityDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class GetTester {

	public static void main(String[] args) {
		EmployeeDAO dao=new EmployeeDAO();
		dao.getEmployeeAndUniversity(new Long(1));
		
	}

}
