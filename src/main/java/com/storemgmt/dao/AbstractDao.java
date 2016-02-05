package com.storemgmt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.storemgmt.util.AuditLogInterceptor;

import java.util.*;

@Repository("AbstractDao")
public class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AuditLogInterceptor auditLogInterceptor;
	
	public Session getSession() throws NullPointerException
	{
		if(sessionFactory != null)
		{
			return  sessionFactory.getCurrentSession();
					//sessionFactory.withOptions().interceptor(auditLogInterceptor).openSession();
		}
		else
		{
			throw new NullPointerException();
		}
	}
	
	public void save(Object entity)
	{
		try
		{
			getSession().persist(entity);
		}catch(NullPointerException e)
		{
			e.printStackTrace();

		}
	}
		
	public Session getOpenSession()
	{
		return sessionFactory.openSession();
	}
}
