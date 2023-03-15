package org.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.dto.MobileDTO;

import com.jspiders.hibernate.util.HibernateUtil;

public class MobileDAO 
{
	private SessionFactory factory=HibernateUtil.getSessionFactory();
	public void saveMobile(MobileDTO mobileDTO)
	{
		Transaction transaction=null;
		try(Session session=factory.openSession())
		{
			transaction=session.beginTransaction();
			session.persist(mobileDTO);
			transaction.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
