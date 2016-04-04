package com.storemgmt.service;

import java.util.List;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.model.ProductEntity;

public interface ProductService {
	
	public enum MeasurementScale {Units("Units"),Kg("KG"),liter("Liter");
	
		private String value;
		private MeasurementScale(String value)
		{
			this.value = value;
		}
	
		public String getValue()
		{
			return this.value;
		}
	
	};

	public void addProduct(ProductFormBean saveProductFormBean);
	
	public void updateProduct(ProductFormBean updateProductFormBean);
	
	public ProductEntity getProduct(ProductEntity productEntity);
	
	public ProductEntity getProductById(long productId);
	
	public List<ProductFormBean> getProducts();
	
	public boolean searchForDuplicateProductName(String productName);
}
