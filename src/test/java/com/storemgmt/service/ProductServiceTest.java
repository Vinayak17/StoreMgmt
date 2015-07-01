package com.storemgmt.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.storemgmt.config.SpringConfig;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.ProductEntity;
import com.storemgmt.model.TransactionEntity;

public class ProductServiceTest {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
	@Test
	public void test() {
		
		ProductService service = (ProductService) appContext.getBean("ProductServiceImpl");
		ProductEntity productEntity = (ProductEntity) appContext.getBean("ProductEntity");
				
		productEntity.setProdName("FirstProduct");
		productEntity.setProdType(1);
		productEntity.setProdSubType(0);
		productEntity.setProdDesc("Wtf");
		productEntity.setProdEntryDate(new Date());
		service.addProduct(productEntity);
		
		productEntity.setProdName("Updated Product");
		service.updateProduct(productEntity);
		
		
		System.out.println(service.getProduct(productEntity));
		
	}

}
