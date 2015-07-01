package com.storemgmt.dao;

import java.util.List;

import com.storemgmt.model.TransactionEntity;

public interface TransactionDao {

	void createTransaction(TransactionEntity transactionEntity);
	
	void updateTransaction(TransactionEntity transactionEntity);
	
	TransactionEntity fetchTransaction(TransactionEntity transactionEntity);
	
	List<TransactionEntity> fetchTransactions();
	
	
}
