package com.storemgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storemgmt.dao.ConfigurableParameterDAO;
import com.storemgmt.model.ProductSubType;
import com.storemgmt.model.ProductType;


@Service("ConfigurableParameterService")
public class ConfigurableParameterService {
	
	@Autowired
	private ConfigurableParameterDAO configurableParameterDAO;


	public List<ProductType> getAllProductTypes()
	{
		return configurableParameterDAO.getProductTypes();
	}

	public void insertProductType()
	{
		ProductType newProductType = new ProductType();
		newProductType.setType_name("type 1");
		
		ProductType newProductType2 = new ProductType();
		newProductType2.setType_name("type 2");
		
		configurableParameterDAO.insertProductType(newProductType);
		configurableParameterDAO.insertProductType(newProductType2);
	}
	
	public void insertProductSubType()
	{
		ProductSubType newProductType = new ProductSubType();
		newProductType.setSubTypeName("Sub type 1");
		
		ProductSubType newProductType2 = new ProductSubType();
		newProductType2.setSubTypeName("Sub type 2");
		
		configurableParameterDAO.insertProductType(newProductType);
		configurableParameterDAO.insertProductType(newProductType2);

		
	}
}
