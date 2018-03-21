package com.niranjan.hibernate.DAO;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niranjan.hibernate.DTO.EmployeeDTO;
import com.niranjan.hibernate.DTO.UniversityDTO;
import com.niranjan.hibernate.util.HibernateUtil;

public class EmployeeDAO {
	SessionFactory factory=HibernateUtil.getFactory();
	public  void createEmployeeAndAddress(Set<EmployeeDTO> employees,UniversityDTO university){
		System.out.println("createEmployeeAndAddress method started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.persist(university);
			for(EmployeeDTO employee:employees){
				session.persist(employee);
			}	

			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}

		System.out.println("createEmployeeAndAddress method ended...");
	}
	public EmployeeDTO getEmployeeAndUniversity(Long id) {
		System.out.println("getEmployeeAndUniversity started...");
		Session session=factory.openSession();
		try{
			EmployeeDTO dto=session.get(EmployeeDTO.class, id);
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

	public UniversityDTO getUniversityDTOById(long id){
		System.out.println("getUniversityDTOById started...");
		Session session=factory.openSession();
		UniversityDTO dto=new UniversityDTO();
		try{
			dto=session.get(UniversityDTO.class, id);
			System.out.println(dto);			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");
		return dto;

	}

	public void getEmployeesByUniversityDTO(UniversityDTO udto){
		System.out.println("getEmployeesByUniversityDTO started...");
		Session session=factory.openSession();
		String syntax="select e from EmployeeDTO e where e.university=:u";
		try{
			Query query=session.createQuery(syntax);
			query.setParameter("u", udto);
			List<EmployeeDTO> list=query.list();
			System.out.println(list.isEmpty());
			for(EmployeeDTO e:list){
				System.out.println(e);
			}			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");

	}

	public void deleteEmployeeById(long id){
		System.out.println("deleteEmployeeById started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		String syntax="delete from EmployeeDTO e where e.id=:id";
		try{
			Query query=session.createQuery(syntax);
			query.setParameter("id", id);
			int rows=query.executeUpdate();
			System.out.println("rows affected:"+rows);
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("getEmployeeAndAdress ended...");

	}
	public void editEmployee(EmployeeDTO dto){
		System.out.println("editEmployee started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		//String syntax="delete from EmployeeDTO e where e.id=:id";
		try{
			/*Query query=session.createQuery(syntax);
			query.setParameter("id", id);
			*/
			
			//int rows=query.executeUpdate();
			session.update(dto);
			tx.commit();
			//System.out.println("rows affected:"+rows);
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		System.out.println("editEmployee ended...");

	}
	
	
}
