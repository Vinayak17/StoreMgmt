package com.storemgmt.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.TransactionDao;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@Service("PurchaseTransactionServiceImpl")
@Transactional(readOnly = true)
public class PurchaseTransactionServiceImpl extends	GenericTransactionServiceImpl {

	@Autowired
	@Qualifier("GenericTransactionDaoImpl")
	TransactionDao genericTransactionDao;

	@Autowired
	@Qualifier("PurchaseTransactionDaoImpl")
	TransactionDao purchaseTransactionDao;
	
	public static final Logger debugLogger = Logger.getLogger("debugLogger"); 
	
	@Transactional(readOnly = false)
	@Override
	public void createTransaction(TransactionEntity transactionEntity) {
		
		debugLogger.debug("createTransaction(TransactionEntity transactionEntity) called from PurchaseTransactionServiceImpl");
		
		transactionEntity.setCrDrFlg(DEBIT);
		transactionEntity.setSellBuyFlg(PURCHASE);
		
		for(InventoryEntity inventoryEntity : transactionEntity.getItemList())
		{
			inventoryEntity.setCrDrFlag(CREDIT);			
		}
		
		genericTransactionDao.createTransaction(transactionEntity);
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void updateTransaction(TransactionEntity transactionEntity) {
		
		debugLogger.debug("updateTransaction(TransactionEntity transactionEntity) called from PurchaseTransactionServiceImpl");
		
		genericTransactionDao.updateTransaction(transactionEntity);
	}
	
	@Override
	public TransactionEntity fetchTransactionById(TransactionEntity transactionEntity) {
		
		debugLogger.debug("fetchTransactionById(TransactionEntity transactionEntity) called from PurchaseTransactionServiceImpl");
		
		return genericTransactionDao.fetchTransactionById(transactionEntity);
	}
	
	@Override
	public List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy)
	{
		debugLogger.debug("fetchTransactions(Map<String,Integer> orderBy) called from PurchaseTransactionServiceImpl");
		
		return transactionDao.fetchTransactions(orderBy);
	}
	
}
