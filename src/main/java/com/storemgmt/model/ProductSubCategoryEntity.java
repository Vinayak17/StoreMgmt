package com.storemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_SubCategory")
public class ProductSubCategoryEntity implements IAuditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subCategoryId")
	private int subCategoryId;
	
	@Column(name = "subCategoryName")
	private String subCategoryName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="parentCategory")
	private ProductCategoryEntity parentCategory;
	
	
	
	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subTypeId) {
		this.subCategoryId = subTypeId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subTypeName) {
		this.subCategoryName = subTypeName;
	}

	public ProductCategoryEntity getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ProductCategoryEntity parentProductType) {
		this.parentCategory = parentProductType;
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
