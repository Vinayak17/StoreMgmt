package com.storemgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.ProductEntity;

@Repository("ProductDaoImpl")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	public void addProduct(ProductEntity productEntity) {
		
		save(productEntity);
	}

	public boolean deleteProduct(ProductEntity productEntity) {
	
		getSession().delete(productEntity);
		return false;
	}

	public boolean updateProduct(ProductEntity productEntity) {
		getSession().merge(productEntity);
		return true;
	}

	public ProductEntity getProduct(ProductEntity productEntity) {
		
		return (ProductEntity)getSession().get(ProductEntity.class, productEntity.getProdId());
	}

	@SuppressWarnings("unchecked")
	public List<ProductEntity> getProducts() {
		Criteria criteria = getSession().createCriteria(ProductEntity.class);
		return (List<ProductEntity>)criteria.list();
	}

	public ProductEntity getProductById(long productId) {
		ProductEntity productEntity = (ProductEntity)getSession().load(ProductEntity.class, new Long(productId));
		return productEntity;
	}

}
