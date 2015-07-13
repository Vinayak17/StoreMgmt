package com.storemgmt.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.TransactionEntity;

@Repository("GenericTransactionDaoImpl")
public class GenericTransactionDaoImpl extends AbstractDao implements TransactionDao {

	
	private static final Logger debugLogger = Logger.getLogger("debugLogger");
	//private static final Logger debugLogger = Logger.getLogger(GenericTransactionDaoImpl.class);
	
	protected final static byte SELL = 1;
	protected final static byte PURCHASE = 2;
	
	protected final static byte CREDIT = 1;
	protected final static byte DEBIT = 2;
	
	
	public void createTransaction(TransactionEntity transactionEntity) {
		debugLogger.debug("Save Transaction into DB thr createTransaction from GenericTransactionDaoImpl");
		save(transactionEntity);
	}

	public void updateTransaction(TransactionEntity transactionEntity) {
	
		debugLogger.debug("Update Transaction into DB -- createTransaction from GenericTransactionDaoImpl");
		getSession().update(transactionEntity);

	}

	public TransactionEntity fetchTransactionById(TransactionEntity transactionEntity) {
		
		debugLogger.debug("Get particular Generic Transaction of given ID-- fetchTransactionById from GenericTransactionDaoImpl");
		return (TransactionEntity) getSession().get(TransactionEntity.class, transactionEntity.getTxnId());
	}

	@SuppressWarnings("unchecked")
	public List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy) {
		
		debugLogger.debug("Get List of all transaction from DB by given order -- fetchTransactions from GenericTransactionDaoImpl");
		int size = orderBy.size();
		Criteria transactionCriteria = getSession().createCriteria(TransactionEntity.class);
		
		
		if(size == 0 )
			return (List<TransactionEntity>) transactionCriteria.list();
		else
		{
			for( String column : orderBy.keySet())
			{
				if(orderBy.get(column) == 1)
					transactionCriteria.addOrder(Order.desc(column));
				else if(orderBy.get(column) == 2)
				transactionCriteria.addOrder(Order.asc(column));
			}
			
			return transactionCriteria.list();
		}
	}

}
