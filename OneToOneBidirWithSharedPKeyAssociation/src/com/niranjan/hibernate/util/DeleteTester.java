package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.AddressDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class DeleteTester {

	public static void main(String[] args) {
		EmployeeDAO dao=new EmployeeDAO();
		dao.deleteEmployeeAndAddress(new Long(1));
		
	}

}
