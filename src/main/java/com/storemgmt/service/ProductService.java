package com.storemgmt.service;

import java.util.List;

import com.storemgmt.model.ProductEntity;

public interface ProductService {

	public void addProduct(ProductEntity productEntity);
	
	public void updateProduct(ProductEntity productEntity);
	
	public ProductEntity getProduct(ProductEntity productEntity);
	
	public List<ProductEntity> getProducts();
}
