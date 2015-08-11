package com.storemgmt.service;

import java.util.List;
import java.util.Map;

import com.storemgmt.model.TransactionEntity;

public interface TransactionService {

	public void createTransaction(TransactionEntity transactionEntity) throws Exception;
	
	public void updateTransaction(TransactionEntity transactionEntity);
	
	public TransactionEntity fetchTransactionById(TransactionEntity transactionEntity);
	
	public List<TransactionEntity> fetchTransactions(Map<String, Integer> orderBy);
}
