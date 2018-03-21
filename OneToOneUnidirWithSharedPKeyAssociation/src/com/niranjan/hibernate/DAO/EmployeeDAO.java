package com.niranjan.hibernate.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niranjan.hibernate.DTO.AddressDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;
import com.niranjan.hibernate.util.HibernateUtil;

public class EmployeeDAO {
	SessionFactory factory=HibernateUtil.getFactory();
	public  void createEmployeeAndAddress(EmployeeDTO employeeDTO,AddressDTO addressDTO){
		System.out.println("createEmployeeAndAddress method started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			//session.persist(addressDTO); /* this is optional when you use cascadeType as ALL or relavant */
			session.persist(employeeDTO);
			System.out.println("persisted");
			addressDTO.setAddressId(employeeDTO.getUserId());
			employeeDTO.setAddress(addressDTO);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}

		System.out.println("createEmployeeAndAddress method started...");
	}
	public void getEmployeeAndAdress(Long id) {
		System.out.println("getEmployeeAndAdress started...");
		Session session=factory.openSession();
		try{
			EmployeeDTO dto=session.get(EmployeeDTO.class, id);
			System.out.println(dto);
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");
		
	}
}
