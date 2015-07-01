/**
 * 
 */
package com.storemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.TransactionDao;
import com.storemgmt.dao.TransactionDaoImpl;
import com.storemgmt.model.TransactionEntity;

/**
 * @author Vinayak Hegde
 *
 */
@Service("TransactionServiceImpl")
@Transactional(readOnly = true)
public class TransactionServiceImpl implements TransactionService {

	/* (non-Javadoc)
	 * @see com.storemgmt.service.TransactionService#createTransaction(com.storemgmt.model.TransactionEntity)
	 */
	@Autowired
	TransactionDao transactionDao;
	
	@Transactional(readOnly = false)
	public void createTransaction(TransactionEntity transactionEntity) {
		
		transactionDao.createTransaction(transactionEntity);
	}

	/* (non-Javadoc)
	 * @see com.storemgmt.service.TransactionService#updateTransaction(com.storemgmt.model.TransactionEntity)
	
	 */
	@Transactional(readOnly = false)
	public void updateTransaction(TransactionEntity transactionEntity) {
		transactionDao.updateTransaction(transactionEntity);
		
	}

	/* (non-Javadoc)
	 * @see com.storemgmt.service.TransactionService#fetchTransaction(com.storemgmt.model.TransactionEntity)
	 */
	public TransactionEntity fetchTransaction(TransactionEntity transactionEntity) {
		
		return transactionDao.fetchTransaction(transactionEntity);
	}

	/* (non-Javadoc)
	 * @see com.storemgmt.service.TransactionService#fetchTransactions()
	 */
	public List<TransactionEntity> fetchTransactions() {
	
		return transactionDao.fetchTransactions();
	}

}
