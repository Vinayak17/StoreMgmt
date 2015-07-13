package com.storemgmt.dao;

import java.util.List;
import java.util.Map;

import com.storemgmt.model.TransactionEntity;

public interface TransactionDao {

	void createTransaction(TransactionEntity transactionEntity);
	
	void updateTransaction(TransactionEntity transactionEntity);
	
	TransactionEntity fetchTransactionById(TransactionEntity transactionEntity);
	
	List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy);
	
	
}
