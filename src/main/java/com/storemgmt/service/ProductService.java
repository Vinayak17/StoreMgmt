package com.storemgmt.service;

import java.util.List;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.model.ProductEntity;

public interface ProductService {

	public void addProduct(ProductFormBean productFormBean);
	
	public void updateProduct(ProductFormBean productFormBean) throws Exception;
	
	public ProductFormBean getProduct(ProductFormBean productFormBean) throws Exception;
	
	public List<ProductEntity> getProducts();
	public ProductFormBean getProductById(long productId);
}
