package com.storemgmt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component("AuditLog")
@Entity(name= "AuditLog")
@Table(name = "auditlog")
public class AuditLog implements Serializable {

	/**
	 * Table to store keep the track of queries modified by user
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auditLogId", nullable = false)
	private Long auditLogId;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "createdDate")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime createdDate;
	
	@Column(name = "entityId")
	private long entityId;
	
	@Column(name = "entityName")
	private String entityName;

	public Long getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(Long auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	
}
