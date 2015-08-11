/**
 * 
 */
package com.storemgmt.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.TransactionDao;
import com.storemgmt.dao.GenericTransactionDaoImpl;
import com.storemgmt.model.TransactionEntity;

/**
 * @author Vinayak Hegde
 *
 */
@Service("GenericTransactionServiceImpl")
@Transactional(readOnly = true)
public class GenericTransactionServiceImpl implements TransactionService {

	@Autowired
	@Qualifier("GenericTransactionDaoImpl")
	TransactionDao transactionDao;
	
	private static final Logger logger = Logger.getLogger("debugLogger");
	
	protected final static byte SELL = 1;
	protected final static byte PURCHASE = 2;
	
	protected final static byte CREDIT = 1;
	protected final static byte DEBIT = 2;
	
	
	@Transactional(readOnly = false)
	public void createTransaction(TransactionEntity transactionEntity) throws Exception {
		logger.debug("createTransaction(TransactionEntity TransactionEntity) from GenericTransactionServiceImpl called which in calls createTransaction(transactionEntity) from transactionDao ");
		transactionDao.createTransaction(transactionEntity);
	}

	@Transactional(readOnly = false)
	public void updateTransaction(TransactionEntity transactionEntity) {
		logger.debug("updateTransaction(TransactionEntity transactionEntity) from GenericTransactionServiceImpl called which in calls updateTransaction(transactionEntity) from transactionDao ");
		transactionDao.updateTransaction(transactionEntity);
		
	}

	public TransactionEntity fetchTransactionById(TransactionEntity transactionEntity) {
		logger.debug("fetchTransactionById(TransactionEntity transactionEntity) from GenericTransactionServiceImpl called which in calls fetchTransactionById(transactionEntity) from transactionDao ");
		return transactionDao.fetchTransactionById(transactionEntity);
	}

	public List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy) {
	
		logger.debug("fetchTransactions(String[] orderBy) from GenericTransactionServiceImpl called which in calls fetchTransactions(orderBy) from transactionDao ");
		return transactionDao.fetchTransactions(orderBy);
	}

}
