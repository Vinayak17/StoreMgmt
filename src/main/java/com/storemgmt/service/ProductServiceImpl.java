package com.storemgmt.service;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.dao.ProductDaoImpl;
import com.storemgmt.model.ProductEntity;

@Service("ProductServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

	
	private static final byte USAGE_FLAG = 1;
	@Autowired
	private ProductDaoImpl productDaoImpl;
	
	
	
	public void addProduct(ProductFormBean productFormBean) {
		ProductEntity productEntity = convertProductFormBeanToEntity(productFormBean);
		productEntity.setCreatedOn(LocalDate.now());
		productEntity.setProdEntryDate(LocalDate.now());
		productEntity.setProdUsgFlg(USAGE_FLAG);
		productDaoImpl.addProduct(productEntity);

	}

	public void updateProduct(ProductFormBean productFormBean) throws Exception {
		
		if(getProduct(productFormBean) == null)
		{
			throw new Exception();
		}
		else
		{
			ProductEntity productEntity = convertProductFormBeanToEntity(productFormBean);
			productDaoImpl.updateProduct(productEntity);
		}

	}

	public ProductFormBean getProduct(ProductFormBean productFormBean) throws Exception{
		ProductEntity productEntity = convertProductFormBeanToEntity(productFormBean);
		ProductEntity productReturned = productDaoImpl.getProduct(productEntity);
		
		if(productReturned == null)
		{
			throw new Exception();
		}
		else{			
			ProductFormBean returnedProductFormBean = convertProductEntityToProductFormBean(productReturned);
			return returnedProductFormBean;
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
	public ProductFormBean getProductById(long productId)
	{
		ProductEntity newProductEntity = new ProductEntity();
		newProductEntity.setProdId(productId);
		ProductEntity productEntity = productDaoImpl.getProduct(newProductEntity);
		ProductFormBean productFormBean = convertProductEntityToProductFormBean(productEntity);
		return productFormBean;
	}
	private ProductFormBean convertProductEntityToProductFormBean(ProductEntity productEntity)
	{
		ProductFormBean productFormBean = new ProductFormBean();
		productFormBean.setBarCode(productEntity.getBarCode());
		productFormBean.setProdDesc(productEntity.getProdDesc());
		productFormBean.setProdEntryDate(productEntity.getProdEntryDate());
		productFormBean.setProdId(productEntity.getProdId());
		productFormBean.setProdName(productEntity.getProdName());
		productFormBean.setProdSubType(productEntity.getProdSubType());
		productFormBean.setProdType(productEntity.getProdType());
		productFormBean.setProdUsgFlg(productEntity.getProdUsgFlg());
		return productFormBean;
	}
	private ProductEntity convertProductFormBeanToEntity(ProductFormBean productFormBean)
	{
		ProductEntity productEntity = new ProductEntity();
		productEntity.setBarCode(productFormBean.getBarCode());
		productEntity.setProdDesc(productFormBean.getProdDesc());
		productEntity.setProdEntryDate(productFormBean.getProdEntryDate());
		productEntity.setProdId(productFormBean.getProdId());
		productEntity.setProdName(productFormBean.getProdName());
		productEntity.setProdUsgFlg(productFormBean.getProdUsgFlg());
		productEntity.setProdType(productFormBean.getProdType());
		productEntity.setProdSubType(productFormBean.getProdSubType());
		return productEntity;
	}
}
