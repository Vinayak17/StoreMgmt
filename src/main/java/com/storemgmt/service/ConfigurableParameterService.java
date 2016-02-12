package com.storemgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.bean.ProductSubCategoryBean;
import com.storemgmt.bean.ProductCategoryBean;
import com.storemgmt.dao.ConfigurableParameterDAO;
import com.storemgmt.model.ProductSubCategoryEntity;
import com.storemgmt.model.ProductCategoryEntity;


@Service("ConfigurableParameterService")
@Transactional
public class ConfigurableParameterService {
	
	@Autowired
	private ConfigurableParameterDAO configurableParameterDAO;


	public List<ProductCategoryBean> getProductCategories()
	{
		List<ProductCategoryBean> productTypeBeanList = new ArrayList<ProductCategoryBean>();
		for(ProductCategoryEntity fetchedProductTypeEntity :configurableParameterDAO.getProductCategories())
		{
			productTypeBeanList.add(ProductCategoryBean.toProductTypeBean(fetchedProductTypeEntity));
		}
		return productTypeBeanList;
	}

	public List<ProductSubCategoryBean> getProductSubCategories()
	{
		List<ProductSubCategoryBean> productSubTypeBeanList = new ArrayList<ProductSubCategoryBean>();
		for(ProductSubCategoryEntity fetchedProductSubTypeEntity :configurableParameterDAO.getProductSubCategories())
		{
			productSubTypeBeanList.add(ProductSubCategoryBean.toProductSubTypeBean(fetchedProductSubTypeEntity));
		}
		return productSubTypeBeanList;
	}

	public void insertProductType()
	{
		ProductCategoryEntity newProductType = new ProductCategoryEntity();
		newProductType.setCategoryName("type 1");
		
		ProductCategoryEntity newProductType2 = new ProductCategoryEntity();
		newProductType2.setCategoryName("type 2");
		
		configurableParameterDAO.insertProductCategory(newProductType);
		configurableParameterDAO.insertProductCategory(newProductType2);
	}
	
	public void insertProductSubType()
	{
		ProductSubCategoryEntity newProductType = new ProductSubCategoryEntity();
		ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
		productCategoryEntity.setCategoryId(1);
		newProductType.setSubCategoryName("Sub type 1");
		newProductType.setParentCategory(productCategoryEntity);
		
		ProductSubCategoryEntity newProductType2 = new ProductSubCategoryEntity();
		newProductType2.setSubCategoryName("Sub type 2");
		newProductType2.setParentCategory(productCategoryEntity);
		
		configurableParameterDAO.insertProductSubCategory(newProductType);
		configurableParameterDAO.insertProductSubCategory(newProductType2);

		
	}
}
