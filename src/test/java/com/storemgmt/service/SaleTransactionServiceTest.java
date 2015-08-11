package com.storemgmt.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.storemgmt.config.SpringConfig;
import com.storemgmt.dao.TransactionDao;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.ProductEntity;
import com.storemgmt.model.TransactionEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class SaleTransactionServiceTest {
	
	@Autowired
	com.storemgmt.model.EntityManager EntityManager;
	//------------------------------------------------
	
	@Mock
	TransactionDao genericTransactionDao;
	
	@Mock
	ProductServiceImpl productServiceImpl;
	
	@InjectMocks
	SaleTransactionServiceImpl saleTransactionServiceImpl;
	
	@Spy
	TransactionEntity transactionEntity;
	
	@Spy
	InventoryEntity inventoryEntity;
	
	@Spy
	ProductEntity productEntity;
	
	@Spy
	List<InventoryEntity> itemList = new ArrayList<InventoryEntity>();
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		transactionEntity = getTransactionEntity();
	}
	
	
	public void createSaleTransactionSuccessfully() throws Exception
	{
		doNothing().when(genericTransactionDao).createTransaction(transactionEntity);
		Mockito.doReturn(getProduct()).when(productServiceImpl).getProduct(productEntity);
		saleTransactionServiceImpl.createTransaction(transactionEntity);
		verify(genericTransactionDao, times(1)).createTransaction(transactionEntity);
		assertEquals(1, transactionEntity.getCrDrFlg());
		assertEquals(1, transactionEntity.getSellBuyFlg());
		assertEquals(2, transactionEntity.getItemList().get(0).getCrDrFlag());
	}
	
	
	@Test
	public void createSaleTransactionWithProdIdException() throws Exception
	{
		
	}
	
	public void createSaleTransaction() throws Exception
	{
		for(int i= 0; i<5 ;i++)
		{
				
				List<InventoryEntity> itemList = new ArrayList<InventoryEntity>();
				TransactionEntity transactionEntity = EntityManager.getTransactionEntity();
				for( int j = 0; j<2; j++)
				{
					InventoryEntity inventoryEntity = EntityManager.getInventoryEntity();
					inventoryEntity.setProdId(j);
					inventoryEntity.setInvTxnDt(new Date());
					inventoryEntity.setProdName("Product Sale" +j);
					inventoryEntity.setQty(5);
					inventoryEntity.setPpu(23*j);
					inventoryEntity.setMfgId(j);
					inventoryEntity.setMfgName("Manufacturer "+ j);
					inventoryEntity.setCrDrFlag(2);
					itemList.add(inventoryEntity);
				}
				
				transactionEntity.setCustId(99676476L);
				transactionEntity.setTxnDt(new Date());
				transactionEntity.setTrueDt(new Date());
				transactionEntity.setTxnStatus(1);
				transactionEntity.setTxnSubTotal(91);
				transactionEntity.setTxnTotal(3200);
				transactionEntity.setItemList(itemList);
				transactionEntity.setCrDrFlg(1);
				transactionEntity.setSellBuyFlg(1);
				saleTransactionServiceImpl.createTransaction(transactionEntity);
		}		
	}
	
	
	
	private TransactionEntity getTransactionEntity() {
		
		transactionEntity.setCustId(12345L);
		transactionEntity.setItemList(getItemList());
		transactionEntity.setTrueDt(new Date());
		transactionEntity.setTxnAmtPaid(300.00f);
		transactionEntity.setTxnDt(new Date());
		
		return transactionEntity;
	}

	private List<InventoryEntity> getItemList() {
		
		inventoryEntity = new InventoryEntity();
		
		inventoryEntity.setInvTxnDt(new Date());
		inventoryEntity.setMfgId(1);
		inventoryEntity.setPpu(12);
		inventoryEntity.setProdId(1);
		inventoryEntity.setQty(2);
		
		itemList.add(inventoryEntity);
		
		inventoryEntity = new InventoryEntity();
		inventoryEntity.setInvTxnDt(new Date());
		inventoryEntity.setMfgId(1);
		inventoryEntity.setPpu(12);
		inventoryEntity.setProdId(2);
		inventoryEntity.setQty(2);
		
		itemList.add(inventoryEntity);
		
		return itemList;
	}
	
	private ProductEntity getProduct() {
		
		productEntity.setProdName("Bhujia");
		productEntity.setProdType(1);
		productEntity.setProdSubType(0);
		productEntity.setProdDesc("Bhujia");
		productEntity.setProdEntryDate(LocalDate.now());
				
		return productEntity;
	}
}
