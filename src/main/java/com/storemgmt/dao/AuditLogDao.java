package com.storemgmt.dao;

import org.hibernate.Session;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.storemgmt.model.AuditLog;
import com.storemgmt.model.IAuditable;

@Repository("AuditLogDao")
public class AuditLogDao extends AbstractDao {

	//@Autowired
	protected AuditLog auditLog;

	public void LogIt(String action, IAuditable entity) {

		// AuditLog auditRecord = new AuditLog(action, entity.getLogDeatil(),new
		// Date(), entity.getId(), entity.getClass().toString());
		
		auditLog = new AuditLog();
		auditLog.setAction(action);
		auditLog.setCreatedDate(LocalDateTime.now());
		auditLog.setEntityId(entity.getId());
		auditLog.setEntityName(entity.getClass().toString());

		save(auditLog);
	}
}
