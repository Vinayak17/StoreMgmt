package com.storemgmt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.ProductSubCategoryEntity;
import com.storemgmt.model.ProductCategoryEntity;

@Repository("ConfigurableParameterDAO")
public class ConfigurableParameterDAO extends AbstractDao{

	public void insertProductCategory(ProductCategoryEntity productTypeInp)
	{
		getSession().save(productTypeInp);
	}
	public List<ProductCategoryEntity> getProductCategories()
	{
		Map<Integer,String> productTypesMap = new HashMap<Integer, String>();
		
		Criteria criteria = getSession().createCriteria(ProductCategoryEntity.class);
		List<ProductCategoryEntity> productTypesList = criteria.list();
		
		for(ProductCategoryEntity type : productTypesList)
		{
			productTypesMap.put(type.getCategoryId(), type.getCategoryName());
		}
		
		return productTypesList;
	}
	
	public void insertProductSubCategory(ProductSubCategoryEntity productSubTypeInp)
	{
		getSession().save(productSubTypeInp);
	}
	
	public List<ProductSubCategoryEntity> getProductSubCategories()
	{
		Map<Integer,String> productTypesMap = new HashMap<Integer, String>();
		
		Criteria criteria = getSession().createCriteria(ProductSubCategoryEntity.class);
		List<ProductSubCategoryEntity> productSubTypesList = criteria.list();
		
		for(ProductSubCategoryEntity type : productSubTypesList)
		{
			productTypesMap.put(type.getSubCategoryId(), type.getSubCategoryName());
		}
		
		return productSubTypesList;
	}
	
}
