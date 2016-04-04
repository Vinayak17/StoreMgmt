package com.storemgmt.bean;

import com.storemgmt.model.ProductCategoryEntity;
import com.storemgmt.model.ProductSubCategoryEntity;

public class ConfigurableParameterFormBean {

	private String configurationName;
	
	private int productCategoryId;
	
	private String productCategoryName;
	
	private int productSubCategoryId;
	
	private String productSubCategoryName;

	public String getConfigurationName() {
		return configurationName;
	}

	public void setConfigurationName(String configurationName) {
		this.configurationName = configurationName;
	}
	
	
	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String categoryName) {
		this.productCategoryName = categoryName;
	}

	public String getProductSubCategoryName() {
		return productSubCategoryName;
	}

	public void setProductSubCategoryName(String subCategoryName) {
		this.productSubCategoryName = subCategoryName;
	}
	
	
	
	public int getProductSubCategoryId() {
		return productSubCategoryId;
	}

	public void setProductSubCategoryId(int productSubCategoryId) {
		this.productSubCategoryId = productSubCategoryId;
	}

	public ProductCategoryEntity toProductCategoryEntity()
	{
		ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
		
		productCategoryEntity.setCategoryName(this.getProductCategoryName());
		
		return productCategoryEntity;
	}
	
	public ProductSubCategoryEntity toProductSubCategoryEntity()
	{
		ProductSubCategoryEntity productSubCategoryEntity = new ProductSubCategoryEntity();
		ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
		if(getProductCategoryId() != 0)
		{
			productCategoryEntity.setCategoryId(getProductCategoryId());
		}
		
		if(getProductCategoryName() != null)
		{
			productCategoryEntity.setCategoryName(getProductCategoryName());
		}
		
		if(getProductSubCategoryName() != null)
		{
			productSubCategoryEntity.setSubCategoryName(getProductSubCategoryName());
		}
		if(getProductSubCategoryId() != 0)
		{
			productSubCategoryEntity.setSubCategoryId(getProductSubCategoryId());
		}
		productSubCategoryEntity.setParentCategory(productCategoryEntity);
		
		
		return productSubCategoryEntity;
	}
	
	
	
}
