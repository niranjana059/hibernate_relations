package com.niranjan.custom.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IFSCCodeGenerator implements IdentifierGenerator{

	public static final String PREFIX="HDFC";

	public static final int INITIAL_VALUE=000001;

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Connection con=session.connection();
		String syntax="select id from HDFC order by creation_date desc limit 1";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(syntax);
			String highest_id=null;
			while(rs.next()){				
				highest_id=rs.getString("id");
				System.out.println("got the id:"+highest_id);
			}
			if(highest_id!=null){
				int i=Integer.valueOf(highest_id.substring(4, highest_id.length()));
				i++;
				String formatedInteger=String.format("%06d", i);
				System.out.println("::"+formatedInteger);
				return PREFIX+formatedInteger;
			}
			return PREFIX+INITIAL_VALUE;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
