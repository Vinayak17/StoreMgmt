package com.storemgmt.service;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.ProductDaoImpl;
import com.storemgmt.model.ProductEntity;

@Service("ProductServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

	
	private static final byte USAGE_FLAG = 1;
	@Autowired
	private ProductDaoImpl productDaoImpl;
	
	
	
	public void addProduct(ProductEntity productEntity) {
		
		productEntity.setCreatedOn(LocalDate.now());
		productEntity.setProdEntryDate(LocalDate.now());
		productEntity.setProdUsgFlg(USAGE_FLAG);
		productDaoImpl.addProduct(productEntity);

	}

	public void updateProduct(ProductEntity productEntity) throws Exception {
		
		if(getProduct(productEntity) == null)
		{
			throw new Exception();
		}
		else
		{
			productDaoImpl.updateProduct(productEntity);
		}

	}

	public ProductEntity getProduct(ProductEntity productEntity) throws Exception{
		
		ProductEntity productReturned = productDaoImpl.getProduct(productEntity);
		
		if(productReturned == null)
		{
			throw new Exception();
		}
		else{			
			return productReturned;
		}
		
	}

	public List<ProductEntity> getProducts() {
		
		return productDaoImpl.getProducts();
	}

	public boolean searchForDuplicateProductName(String productName){
		
		String existingProductName;
		Boolean booleanFlag = false;
		for(ProductEntity productEntity : this.getProducts())
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
