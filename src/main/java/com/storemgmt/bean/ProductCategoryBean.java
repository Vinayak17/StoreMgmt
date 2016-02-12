package com.storemgmt.bean;

import com.storemgmt.model.ProductCategoryEntity;

public class ProductCategoryBean {

	private int categoryId;
	
	private String categoryName;

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
	
	public static ProductCategoryBean toProductTypeBean(ProductCategoryEntity productTypeEntityInp)
	{
		ProductCategoryBean returnProductTypeBean = new ProductCategoryBean();
		returnProductTypeBean.setCategoryId(productTypeEntityInp.getCategoryId());
		returnProductTypeBean.setCategoryName(productTypeEntityInp.getCategoryName());
		
		return returnProductTypeBean;
	}
	
	public ProductCategoryEntity toProductTypeEntity(ProductCategoryEntity productCategoryEntity)
	{
		productCategoryEntity.setCategoryId(this.getCategoryId());
		productCategoryEntity.setCategoryName(this.getCategoryName());
		
		return productCategoryEntity;
	}
}
