package com.storemgmt.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.config.SpringConfig;
import com.storemgmt.dao.ProductDaoImpl;
import com.storemgmt.model.ProductEntity;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProductServiceTest {

	@Mock
	ProductDaoImpl productDaoImpl;
	
	@Spy
	ProductFormBean productFormBean;
	@Spy
	ProductEntity productEntity;
	
	@InjectMocks
	ProductServiceImpl productedServiceImpl;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		productFormBean = getProduct();
	}	

	//@Test
	public void addProductSuccessfully() throws Exception {
		
		doNothing().when(productDaoImpl).addProduct(productEntity);
		productedServiceImpl.addProduct(productFormBean);
		Mockito.verify(productDaoImpl, Mockito.times(1)).addProduct(productEntity);
		//assertEquals(LocalDate.now(), productFormBean.getCreatedOn());
	}
	
	//@Test
	public void updateProductSuccessfully() throws Exception
	{
		Mockito.doReturn(getProduct()).when(productDaoImpl).getProduct(productEntity);
		productedServiceImpl.updateProduct(productFormBean);
		Mockito.verify(productDaoImpl, Mockito.times(1)).updateProduct(productEntity);
		
	}
	
	//@Test
	public void searchForDuplicateNameWithFalse()
	{
		Mockito.doReturn(getProducts()).when(productDaoImpl).getProducts();
		assertFalse(productedServiceImpl.searchForDuplicateProductName("ABC"));
	}
	
	//@Test
	public void searchForDuplicateNameWithTrue()
	{
		Mockito.doReturn(getProducts()).when(productDaoImpl).getProducts();
		assertTrue(productedServiceImpl.searchForDuplicateProductName("BhujiaSEV"));
	}
	
	@After
	public void cleanUp()
	{
		
	}
	
	private ProductFormBean getProduct() {
		
		productFormBean.setProdName("Bhujia");
		productFormBean.setProdType(1);
		productFormBean.setProdSubType(0);
		productFormBean.setProdDesc("Bhujia");
		productFormBean.setProdEntryDate(LocalDate.now());
				
		return productFormBean;
	}
	
	private List<ProductFormBean> getProducts() {
		
		List<ProductFormBean> productList = new ArrayList<ProductFormBean>();
		ProductFormBean product1 = new ProductFormBean();
		product1.setProdName("Bhujia");
		product1.setProdType(1);
		product1.setProdSubType(0);
		product1.setProdDesc("Bhujia");
		product1.setProdEntryDate(LocalDate.now());
		
		productList.add(product1);
		
		ProductFormBean product2 = new ProductFormBean();
		product2.setProdName("Bhujia Sev");
		product2.setProdType(1);
		product2.setProdSubType(0);
		product2.setProdDesc("Bhujia Sev");
		product2.setProdEntryDate(LocalDate.now());
		
		productList.add(product2);
		
		return productList;
	}

}
