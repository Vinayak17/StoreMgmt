package com.storemgmt.service;

import java.util.List;

import com.storemgmt.model.TransactionEntity;

public interface TransactionService {

	public void createTransaction(TransactionEntity transactionEntity);
	
	public void updateTransaction(TransactionEntity transactionEntity);
	
	public TransactionEntity fetchTransaction(TransactionEntity transactionEntity);
	
	public List<TransactionEntity> fetchTransactions();
}
