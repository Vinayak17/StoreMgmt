package com.storemgmt.util;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.storemgmt.dao.AuditLogDao;
import com.storemgmt.model.IAuditable;

@Component("AuditLogInterceptor")
public class AuditLogInterceptor extends EmptyInterceptor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	*/
	@Autowired
	private AuditLogDao auditLogDao;
	
	private Set inserts = new HashSet();
	private Set updates = new HashSet();
	private Set deletes = new HashSet();
	
	/*public void setSession(Session session) {
		this.session=session;
	}*/
	
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
	{
		System.out.println("onSave");
		
		if (entity instanceof IAuditable){
			inserts.add(entity);
		}
		return false;
			
	}
	
	@Override
	public boolean onFlushDirty(Object entity,Serializable id,Object[] currentState,Object[] previousState,	String[] propertyNames,Type[] types) throws CallbackException {
	
		System.out.println("onFlushDirty");
		
		if (entity instanceof IAuditable){
			updates.add(entity);
		}
		return false;
		
	}
	
	@Override
	public void onDelete(Object entity, Serializable id,Object[] state, String[] propertyNames,Type[] types) {
		
		System.out.println("onDelete");
		
		if (entity instanceof IAuditable){
			deletes.add(entity);
		}
	}

	//called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}	
	
	//called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");
		
		try{
			
			for (Iterator it = inserts.iterator(); it.hasNext();) {
				IAuditable entity = (IAuditable) it.next();
			    System.out.println("postFlush - insert");		
			    auditLogDao.LogIt("Saved",entity);
			}	
				
			for (Iterator it = updates.iterator(); it.hasNext();) {
				IAuditable entity = (IAuditable) it.next();
			    System.out.println("postFlush - update");
			    auditLogDao.LogIt("Updated",entity);
			}	
				
			for (Iterator it = deletes.iterator(); it.hasNext();) {
				IAuditable entity = (IAuditable) it.next();
			    System.out.println("postFlush - delete");
			    auditLogDao.LogIt("Deleted",entity);
			}	
				
		} finally {
			inserts.clear();
			updates.clear();
			deletes.clear();
		}
    }		
}