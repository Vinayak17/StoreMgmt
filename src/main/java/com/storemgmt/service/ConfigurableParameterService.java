package com.storemgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.bean.ConfigurableParameterFormBean;
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
	
	public ProductCategoryBean getproductCategoryById(int CategoryId)
	{
		ProductCategoryEntity productCategoryEntity = configurableParameterDAO.getProductCategoryById(CategoryId);
		
		return ProductCategoryBean.toProductTypeBean(productCategoryEntity);
	}
	
	public ProductSubCategoryBean getproductSubCategoryById(int subCategoryId)
	{
		ProductSubCategoryEntity productSubCategoryEntity = configurableParameterDAO.getProductSubCategoryById(subCategoryId);
		
		return ProductSubCategoryBean.toProductSubTypeBean(productSubCategoryEntity);
	}

	public void insertProductType(ConfigurableParameterFormBean configurableParameterFormBean)
	{
		configurableParameterDAO.insertProductCategory(configurableParameterFormBean.toProductCategoryEntity());
	}
	
	public void insertProductSubType(ConfigurableParameterFormBean configurableParameterFormBean)
	{
		/*ProductCategoryEntity productCategoryEntity = configurableParameterDAO.getProductCategoryById(configurableParameterFormBean.getProductCategoryId());
		ProductSubCategoryEntity productSubCategoryEntity = new ProductSubCategoryEntity();
		productSubCategoryEntity.setParentCategory(productCategoryEntity);
		productSubCategoryEntity.setSubCategoryName(configurableParameterFormBean.getProductSubCategoryName());
		*/
		configurableParameterDAO.insertProductSubCategory(configurableParameterFormBean.toProductSubCategoryEntity());
		
	}
	
	
}
