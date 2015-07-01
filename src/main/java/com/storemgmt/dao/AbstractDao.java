package com.storemgmt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Object entity)
	{
		getSession().persist(entity);
	}
		
}
