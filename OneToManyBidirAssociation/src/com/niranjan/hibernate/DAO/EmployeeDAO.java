package com.niranjan.hibernate.DAO;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niranjan.hibernate.DTO.AddressDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;
import com.niranjan.hibernate.util.HibernateUtil;

public class EmployeeDAO {
	SessionFactory factory=HibernateUtil.getFactory();
	public  void createEmployeeAndAddress(EmployeeDTO employeeDTO,Set<AddressDTO> addresses){
		System.out.println("createEmployeeAndAddress method started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			//session.persist(addresses);
			//employeeDTO.setAddresses(addresses);
			session.save(employeeDTO);			
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}

		System.out.println("createEmployeeAndAddress method ended...");
	}
	public void getEmployeeAndAdress(Long id) {
		System.out.println("getEmployeeAndAdress started...");
		Session session=factory.openSession();
		try{
			AddressDTO dto=session.get(AddressDTO.class, id);
			System.out.println(dto);
			System.out.println("employeee------>");
			System.out.println(dto.getEmployee());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");
		
	}
}
