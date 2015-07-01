package com.storemgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.TransactionEntity;

@Repository("TransactionDaoImpl")
public class TransactionDaoImpl extends AbstractDao implements TransactionDao {

	public void createTransaction(TransactionEntity transactionEntity) {
		save(transactionEntity);
	}

	public void updateTransaction(TransactionEntity transactionEntity) {
	
		getSession().update(transactionEntity);

	}

	public TransactionEntity fetchTransaction(TransactionEntity transactionEntity) {
		
		return (TransactionEntity) getSession().get(TransactionEntity.class, transactionEntity.getTxnId());
	}

	@SuppressWarnings("unchecked")
	public List<TransactionEntity> fetchTransactions() {
		
		return (List<TransactionEntity>)getSession().createCriteria(TransactionEntity.class).list();
	
	}

}
