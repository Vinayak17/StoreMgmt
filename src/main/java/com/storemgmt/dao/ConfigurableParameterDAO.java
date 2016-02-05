package com.storemgmt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.ProductSubType;
import com.storemgmt.model.ProductType;

@Repository("ConfigurableParameterDAO")
public class ConfigurableParameterDAO extends AbstractDao{

	public void insertProductType(ProductType productTypeInp)
	{
		getSession().save(productTypeInp);
	}
	public List<ProductType> getProductTypes()
	{
		Map<Integer,String> productTypesMap = new HashMap<Integer, String>();
		
		Criteria criteria = getSession().createCriteria(ProductType.class);
		List<ProductType> productTypesList = criteria.list();
		
		for(ProductType type : productTypesList)
		{
			productTypesMap.put(type.getType_id(), type.getType_name());
		}
		
		return productTypesList;
	}
	
	public void insertProductType(ProductSubType productSubTypeInp)
	{
		getSession().save(productSubTypeInp);
	}
	
	public List<ProductSubType> getProductSubTypes()
	{
		Map<Integer,String> productTypesMap = new HashMap<Integer, String>();
		
		Criteria criteria = getSession().createCriteria(ProductSubType.class);
		List<ProductSubType> productSubTypesList = criteria.list();
		
		for(ProductSubType type : productSubTypesList)
		{
			productTypesMap.put(type.getSubTypeId(), type.getSubTypeName());
		}
		
		return productSubTypesList;
	}
	
}
