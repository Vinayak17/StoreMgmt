package com.storemgmt.service;

import java.util.List;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.model.ProductEntity;

public interface ProductService {

	public void addProduct(ProductFormBean saveProductFormBean);
	
	public void updateProduct(ProductFormBean updateProductFormBean);
	
	public ProductEntity getProduct(ProductEntity productEntity);
	
	public ProductEntity getProductById(long productId);
	
	public List<ProductFormBean> getProducts();
}
