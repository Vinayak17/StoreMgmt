package com.storemgmt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_Category")
public class ProductCategoryEntity implements IAuditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId")
	private int categoryId;
	
	@Column(name = "categoryName", nullable = false)
	private String categoryName;
	
	@OneToMany(mappedBy="parentCategory")
	private List<ProductSubCategoryEntity> productSubCategoryList;
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int typeId) {
		this.categoryId = typeId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String typeName) {
		this.categoryName = typeName;
	}
	
	

	public List<ProductSubCategoryEntity> getProductSubCategoryList() {
		return productSubCategoryList;
	}

	public void setProductSubCategoryList(
			List<ProductSubCategoryEntity> productSubCategoryList) {
		this.productSubCategoryList = productSubCategoryList;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return this.categoryId;
	}

	public String getLogDetail() {
		// TODO Auto-generated method stub
		return null;
	}

}
