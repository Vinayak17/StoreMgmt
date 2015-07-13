package com.storemgmt.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.storemgmt.config.SpringConfig;
import com.storemgmt.model.CheckEntityManager;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class TransactionServiceTest {
	
	@Autowired
	@Qualifier("GenericTransactionServiceImpl")
	TransactionService transactionService ;
	
	@Autowired
	@Qualifier("SaleTransactionServiceImpl")
	TransactionService saleTransactionServiceImpl;
	
	@Autowired
	@Qualifier("PurchaseTransactionServiceImpl")
	TransactionService purchaseTransactionServiceImpl;
	
	@Autowired
	TransactionEntity transactionEntity ;
		
	@Autowired
	com.storemgmt.model.EntityManager EntityManager;
	
	@Test
	public void test() {
		
		addGenericTransactions();
				
	}
	
	public void addGenericTransactions()
	{ 
		for(int i = 1 ;i<=10 ;i++)
		{
			List<InventoryEntity> itemList  = new ArrayList<InventoryEntity>();
			TransactionEntity localTE = EntityManager.getTransactionEntity();
			for( int j = 0; j<5; j++)
			{
				InventoryEntity inventoryEntity = EntityManager.getInventoryEntity();
				inventoryEntity.setProdId(i);
				inventoryEntity.setInvTxnDt(new Date());
				inventoryEntity.setProdName("Product "+i);
				inventoryEntity.setQty(i*2);
				inventoryEntity.setPpu(i+23);
				inventoryEntity.setCrDrFlag(i%2 == 0 ? 2:1);
				itemList.add(inventoryEntity);
			}
			
			localTE.setCustId(679676476L*i);
			localTE.setTxnDt(new Date());
			localTE.setTrueDt(new Date());
			localTE.setTxnStatus(1);
			localTE.setTxnSubTotal(i+100);
			localTE.setTxnTotal(i*200);
			localTE.setCrDrFlg(i%2 == 0 ? 1:2);
			localTE.setSellBuyFlg(i%2 == 0 ? 1:2);
			localTE.setItemList(itemList);
			
			transactionService.createTransaction(localTE);
		}		
	}
	
	@Test
	public void fetchGenericTransactions()
	{
		Map<String,Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("custId", 1);
		hashMap.put("txnTotal", 2);
		List<TransactionEntity> txnList  = saleTransactionServiceImpl.fetchTransactions(hashMap);
		for(TransactionEntity txnEntity : txnList)
			System.out.println(txnEntity);
	}
	
	@Test
	public void updateGenericTransaction()
	{
		Map<String,Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("custId", 1);
		hashMap.put("txnTotal", 2);
		TransactionEntity transactionEntity = transactionService.fetchTransactions(hashMap).get(3);
		
		transactionEntity.setUpdatedOn(new Date());
		
		transactionService.updateTransaction(transactionEntity);
	}
	
	@Test
	public void createSaleTransaction()
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
	
	@Test
	public void createPurchaseTransaction()
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
					inventoryEntity.setProdName("Product purchase "+j);
					inventoryEntity.setQty(100);
					inventoryEntity.setPpu(23*j);
					inventoryEntity.setMfgId(j);
					inventoryEntity.setMfgName("Manufacturer "+ j);
					inventoryEntity.setCrDrFlag(1);
					itemList.add(inventoryEntity);
				}
				
				transactionEntity.setCustId(234476L);
				transactionEntity.setTxnDt(new Date());
				transactionEntity.setTrueDt(new Date());
				transactionEntity.setTxnStatus(1);
				transactionEntity.setTxnSubTotal(91);
				transactionEntity.setTxnTotal(3200);
				transactionEntity.setItemList(itemList);
				transactionEntity.setCrDrFlg(2);
				transactionEntity.setSellBuyFlg(2);
				purchaseTransactionServiceImpl.createTransaction(transactionEntity);
		}
	}
	
}
