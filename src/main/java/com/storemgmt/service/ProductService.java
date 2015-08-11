package com.storemgmt.service;

import java.util.List;

import com.storemgmt.model.ProductEntity;

public interface ProductService {

	public void addProduct(ProductEntity productEntity);
	
	public void updateProduct(ProductEntity productEntity) throws Exception;
	
	public ProductEntity getProduct(ProductEntity productEntity) throws Exception;
	
	public List<ProductEntity> getProducts();
}
