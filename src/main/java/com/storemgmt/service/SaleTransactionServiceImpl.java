package com.storemgmt.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.SaleTransactionDaoImpl;
import com.storemgmt.dao.TransactionDao;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@Service("SaleTransactionServiceImpl")
@Transactional(readOnly = true)
public class SaleTransactionServiceImpl extends GenericTransactionServiceImpl {

	@Autowired
	@Qualifier("GenericTransactionDaoImpl")
	TransactionDao genericTransactionDao;
	
	@Autowired
	@Qualifier("SaleTransactionDaoImpl")
	TransactionDao saleTransactionDao;
	
	
	
	
	protected final static Logger debugLogger = Logger.getLogger("debugLogger");
	
	@Transactional(readOnly = false)
	public void createTransaction(TransactionEntity transactionEntity) {
		
		debugLogger.debug("createTransaction called from SaleTransactionServiceImpl ");
		
		transactionEntity.setCrDrFlg(CREDIT);
		transactionEntity.setSellBuyFlg(SELL);
		for(InventoryEntity inventoryEntity : transactionEntity.getItemList()){
			inventoryEntity.setCrDrFlag(DEBIT);
		}
		genericTransactionDao.createTransaction(transactionEntity);
	}

	@Transactional(readOnly = false)
	public void updateTransaction(TransactionEntity transactionEntity) {
		genericTransactionDao.updateTransaction(transactionEntity);
		
	}

	public TransactionEntity fetchTransactionById(TransactionEntity transactionEntity) {
		
		return genericTransactionDao.fetchTransactionById(transactionEntity);
	}

	public List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy) {
	
		debugLogger.debug("fetchTransactions(Map<String,Integer> orderBy) called from SaleTransactionServiceImpl ");
		
		return saleTransactionDao.fetchTransactions(orderBy);
	}

}
