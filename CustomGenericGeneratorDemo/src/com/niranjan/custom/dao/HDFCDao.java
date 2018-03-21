package com.niranjan.custom.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.niranjan.custom.dto.HDFCDto;

public class HDFCDao {

	SessionFactory factory=HibernateUtil.getSessionFactory();

	public void saveHDFC(HDFCDto dto){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			String str=(String) session.save(dto);
			System.out.println(str);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}
}
