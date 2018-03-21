package com.niranjan.hibernate.util;

import com.niranjan.hibernate.DAO.EmployeeDAO;
import com.niranjan.hibernate.DTO.EmployeeDTO;

public class EditTester {

	public static void main(String[] args) {
		EmployeeDTO dto=new EmployeeDTO();
		EmployeeDAO dao=new EmployeeDAO();
		dto=dao.getEmployeeAndUniversity(new Long(2));
		dto.setFirstName(dto.getFirstName()+" modified");
		dao.editEmployee(dto);

	}

}
