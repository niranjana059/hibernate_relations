package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;

public class DeleteTester {

	public static void main(String[] args) {
		new EmployeeDAO().deleteEmployeeById(1);		
	}

}
