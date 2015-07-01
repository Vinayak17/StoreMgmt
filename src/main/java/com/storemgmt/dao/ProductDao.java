package com.storemgmt.dao;

import java.util.List;

import com.storemgmt.model.ProductEntity;

public interface ProductDao {

	//Add a new Product to your Product List
	public void addProduct(ProductEntity productEntity);
	
	//Delete a Product from your Product List implement with caution as it might delete the linked data in other tables
	public boolean deleteProduct(ProductEntity productEntity);
	
	//update Product
	public boolean updateProduct(ProductEntity productEntity);
	
	public ProductEntity getProduct(ProductEntity productEntity);
	
	public List<ProductEntity> getProducts();
	
	//public long addProducts(List<ProductEntity> productEntityList);
	
	//public boolean deleteProducts(List<ProductEntity> productEntityList);
	
	//public boolean updateProducts(List<ProductEntity> productEntityList);
	
}
