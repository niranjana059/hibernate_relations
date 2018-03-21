package com.niranjan.hibernate.DAO;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niranjan.hibernate.DTO.UniversityDTO;
import com.niranjan.hibernate.DTO.EmployeeDTO;
import com.niranjan.hibernate.util.HibernateUtil;

public class EmployeeDAO {
	SessionFactory factory=HibernateUtil.getFactory();
	public  void createEmployeeAndAddress(UniversityDTO university){
		System.out.println("createEmployeeAndAddress method started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.persist(university);			
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}

		System.out.println("createEmployeeAndAddress method ended...");
	}
	public void getEmployeeAndUniversity(Long id) {
		System.out.println("getEmployeeAndUniversity started...");
		Session session=factory.openSession();
		try{
			UniversityDTO dto=session.get(UniversityDTO.class, id);
			System.out.println(dto);			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");
		
	}
}
