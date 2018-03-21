package com.niranjan.hibernate.DAO;

import javax.mail.Address;

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
			session.save(employeeDTO);			
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}

		System.out.println("createEmployeeAndAddress method started...");
	}
	public EmployeeDTO getEmployeeAndAdress(Long id) {
		System.out.println("getEmployeeAndAdress started...");
		Session session=factory.openSession();
		try{
			EmployeeDTO dto=session.get(EmployeeDTO.class, id);
			//AddressDTO dto=session.get(AddressDTO.class, id);
			System.out.println(dto);
			return dto;
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");
		return null;	
		
	}
	public void deleteEmployeeAndAddress(Long id) {
		System.out.println("deleteEmployeeAndAddress started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			//EmployeeDTO dto=getEmployeeAndAdress(id);
			EmployeeDTO dto=getEmployeeAndAdress(id);
			if(dto!=null){
				session.delete(dto);
			}			
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		System.out.println("deleteEmployeeAndAddress ended...");		
	}
}
