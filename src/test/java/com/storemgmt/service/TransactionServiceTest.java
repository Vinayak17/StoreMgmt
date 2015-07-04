package com.storemgmt.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.storemgmt.config.SpringConfig;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class TransactionServiceTest {

	//ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
	@Autowired
	TransactionService transactionService ;
	@Autowired
	TransactionEntity transactionEntity ;
	@Autowired						//= (TransactionEntity)appContext.getBean("TransactionEntity");
	List<InventoryEntity> itemList ;//= new ArrayList<InventoryEntity>();		
	
	@Autowired
	InventoryEntity inventoryEntity ;
	@Test
	public void test() {
		
		//= (TransactionService) appContext.getBean("TransactionServiceImpl");
		
		//= (InventoryEntity)appContext.getBean("InventoryEntity");
		inventoryEntity.setProdId(23987L);
		inventoryEntity.setInvTxnDt(new Date());
		inventoryEntity.setProdName("Product 0");
		inventoryEntity.setQty(12);
		inventoryEntity.setPpu(23);
		itemList.add(inventoryEntity);
		
		transactionEntity.setCustId(679676476L);
		transactionEntity.setTxnDt(new Date());
		transactionEntity.setTrueDt(new Date());
		transactionEntity.setTxnStatus(1);
		transactionEntity.setTxnSubTotal(100);
		transactionEntity.setTxnTotal(200);
		transactionEntity.setCrDrFlg(1);
		transactionEntity.setSellBuyFlg(1);
		transactionEntity.setItemList(itemList);
		
		transactionService.createTransaction(transactionEntity);
		
		List<TransactionEntity> txnList = transactionService.fetchTransactions();
		for(TransactionEntity txnEntity : txnList)
			System.out.println(txnEntity);
		
	}

}
