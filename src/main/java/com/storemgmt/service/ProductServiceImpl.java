package com.storemgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.dao.ProductDaoImpl;
import com.storemgmt.model.ProductEntity;

@Service("ProductServiceImpl")
//@Transactional
public class ProductServiceImpl implements ProductService {

	
	private static final byte USAGE_FLAG_YES = 1;
	
	@Autowired
	private ProductDaoImpl productDaoImpl;
	
	public void addProduct(ProductFormBean saveProductFormBean) {
		
		ProductEntity saveProductEntity = saveProductFormBean.toProductEntity(new ProductEntity()); 
		saveProductEntity.setCreatedOn(LocalDate.now());
		saveProductEntity.setProdEntryDate(LocalDate.now());
		saveProductEntity.setProdUsgFlg(USAGE_FLAG_YES);
		productDaoImpl.addProduct(saveProductEntity);

	}

	public void updateProduct(ProductFormBean updateProductFormBean){
		
		ProductEntity productEntity = productDaoImpl.getProductById(updateProductFormBean.getProdId());
		ProductEntity updatedProductEntity = updateProductFormBean.toProductEntity(productEntity);
		updatedProductEntity.setUpdatedOn(LocalDate.now());
		productDaoImpl.updateProduct(updatedProductEntity);
	}

	public ProductEntity getProduct(ProductEntity productEntity){
		
		ProductEntity productReturned = productDaoImpl.getProduct(productEntity);
		
		if(productReturned == null)
		{
			//throw new Exception();
			return new ProductEntity();
		}
		else{			
			return productReturned;
		}
		
	}
	
	public ProductEntity getProductById(long productId)
	{
		
		return productDaoImpl.getProductById(productId);
	}

	public List<ProductFormBean> getProducts() {
		
		List<ProductEntity> listOfProductEntity =  productDaoImpl.getProducts();
		List<ProductFormBean> listOfProductFormBeans = new ArrayList<ProductFormBean>();
		
		for(ProductEntity fetchedEntity : listOfProductEntity)
		{
			listOfProductFormBeans.add(ProductFormBean.toProductFormBean(fetchedEntity));
		}
		
		return listOfProductFormBeans;
	}

	public boolean searchForDuplicateProductName(String productName){
		
		String existingProductName;
		Boolean booleanFlag = false;
		for(ProductEntity productEntity : productDaoImpl.getProducts())
		{
			existingProductName = productEntity.getProdName();
			if(existingProductName.equalsIgnoreCase(productName) || existingProductName.toLowerCase().replaceAll("\\s+{2,}", "").trim().contentEquals(productName.toLowerCase().replaceAll("\\s+{2,}", "").trim()))
			{
				booleanFlag = true;
			}			
		}
		
		return booleanFlag;
		
	}
}
