package com.storemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.ProductDaoImpl;
import com.storemgmt.model.ProductEntity;

@Service("ProductServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDaoImpl productDaoImpl;
	public void addProduct(ProductEntity productEntity) {
		productDaoImpl.addProduct(productEntity);

	}

	public void updateProduct(ProductEntity productEntity) {
		productDaoImpl.updateProduct(productEntity);

	}

	public ProductEntity getProduct(ProductEntity productEntity) {
		
		return productDaoImpl.getProduct(productEntity);
	}

	public List<ProductEntity> getProducts() {
		
		return productDaoImpl.getProducts();
	}

}
