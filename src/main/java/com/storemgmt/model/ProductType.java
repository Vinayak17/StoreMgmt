package com.storemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType implements IAuditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private int typeId;
	
	@Column(name = "type_name", nullable = false)
	private String typeName;
	
	
	
	public int getType_id() {
		return typeId;
	}

	public void setType_id(int typeId) {
		this.typeId = typeId;
	}

	public String getType_name() {
		return typeName;
	}

	public void setType_name(String typeName) {
		this.typeName = typeName;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return this.typeId;
	}

	public String getLogDetail() {
		// TODO Auto-generated method stub
		return null;
	}

}
