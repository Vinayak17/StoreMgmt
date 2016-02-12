package com.storemgmt.bean;

import com.storemgmt.model.ProductSubCategoryEntity;

public class ProductSubCategoryBean {
	
	private int subCategoryId;
	
	private String subCategoryName;
	
	private int parentCategoryId;
	
	private String parentCategoryName;

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

	public int getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(int parentTypeId) {
		this.parentCategoryId = parentTypeId;
	}

	public String getParentCategoryName() {
		return parentCategoryName;
	}

	public void setParentCategoryName(String parentTypeName) {
		this.parentCategoryName = parentTypeName;
	}
	
	public static ProductSubCategoryBean toProductSubTypeBean(ProductSubCategoryEntity productSubCategoryEntity)
	{
		ProductSubCategoryBean returnProductSubTypeBean = new ProductSubCategoryBean();
		
		returnProductSubTypeBean.setSubCategoryId(productSubCategoryEntity.getSubCategoryId());
		returnProductSubTypeBean.setSubCategoryName(productSubCategoryEntity.getSubCategoryName());
		returnProductSubTypeBean.setParentCategoryId(productSubCategoryEntity.getParentCategory().getCategoryId());
		returnProductSubTypeBean.setParentCategoryName(productSubCategoryEntity.getParentCategory().getCategoryName());
		return returnProductSubTypeBean;
	}
	
	public ProductSubCategoryEntity toProductSubTypeEntity(ProductSubCategoryEntity productSubCategoryEntity)
	{
		
		productSubCategoryEntity.setSubCategoryId(this.getSubCategoryId());
		productSubCategoryEntity.setSubCategoryName(this.getSubCategoryName());
		productSubCategoryEntity.getParentCategory().setCategoryId(getParentCategoryId());
		productSubCategoryEntity.getParentCategory().setCategoryName(getParentCategoryName());
		
		return productSubCategoryEntity;
	}
}
