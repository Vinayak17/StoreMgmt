package com.storemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_SubType")
public class ProductSubType implements IAuditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subtype_id")
	private int subTypeId;
	
	@Column(name = "subtype_name")
	private String subTypeName;
	
	@ManyToOne
	private ProductType productTypeId;
	
	
	
	public int getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(int subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public ProductType getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(ProductType productTypeId) {
		this.productTypeId = productTypeId;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getLogDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
