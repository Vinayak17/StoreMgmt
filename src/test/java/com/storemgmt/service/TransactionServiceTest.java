package com.storemgmt.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.storemgmt.config.SpringConfig;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

public class TransactionServiceTest {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
	@Test
	public void test() {
		TransactionService transactionService = (TransactionService) appContext.getBean("TransactionServiceImpl");
		
		TransactionEntity transactionEntity = (TransactionEntity)appContext.getBean("TransactionEntity");
		List<InventoryEntity> itemList = new ArrayList<InventoryEntity>();		
		InventoryEntity inventoryEntity = (InventoryEntity)appContext.getBean("InventoryEntity");
		inventoryEntity.setProdId(23987L);
		inventoryEntity.setInvTxnDt(new Date());
		inventoryEntity.setProdName("Tich aayis");
		inventoryEntity.setQty(12);
		inventoryEntity.setPpu(23);
		itemList.add(inventoryEntity);
		
		transactionEntity.setCustId(679676476L);
		transactionEntity.setTxnDt(new Date());
		transactionEntity.setTrueDt(new Date());
		transactionEntity.setTxnStatus(1);
		transactionEntity.setTxnSubTotal(100);
		transactionEntity.setTxnTotal(200);
		transactionEntity.setItemList(itemList);
		
		transactionService.createTransaction(transactionEntity);
		
		List<TransactionEntity> txnList = transactionService.fetchTransactions();
		for(TransactionEntity txnEntity : txnList)
			System.out.println(txnEntity);
		
	}

}
