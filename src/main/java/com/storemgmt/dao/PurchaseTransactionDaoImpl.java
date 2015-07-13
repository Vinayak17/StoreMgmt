package com.storemgmt.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.TransactionEntity;


@Repository("PurchaseTransactionDaoImpl")
public class PurchaseTransactionDaoImpl extends GenericTransactionDaoImpl {

	protected final static Logger debugLogger = Logger.getLogger("debugLogger");
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy)
	{
		debugLogger.debug("fetchTransactions(Map<String,Integer> orderBy) called from PurchaseTransactionDaoImpl");
		Criteria transactionCriteria = getSession().createCriteria(TransactionEntity.class);
		
		transactionCriteria.add(Restrictions.eq("sellBuyFlg", PURCHASE));
		
		int size = orderBy.size();
		if(size == 0)
			return transactionCriteria.list();
		else
		{
			for(String column : orderBy.keySet())
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
