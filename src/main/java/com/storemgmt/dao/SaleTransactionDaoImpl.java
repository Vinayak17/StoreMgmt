package com.storemgmt.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@Repository("SaleTransactionDaoImpl")
public class SaleTransactionDaoImpl extends GenericTransactionDaoImpl {

	public static final Logger debugLogger = Logger.getLogger("debugLogger");
	/*@Override
	public void createTransaction(TransactionEntity transactionEntity)
	{
		
		for(InventoryEntity inventoryEntity : transactionEntity.getItemList())
		{
			inventoryEntity.setCrDrFlag(2);
		}
		transactionEntity.setSellBuyFlg(this.SELL);		
		this.createTransaction(transactionEntity);
	}
	
	@Override
	public void updateTransaction(TransactionEntity transactionEntity)
	{
		if(transactionEntity.getSellBuyFlg() != 1){
			//throw customException
		}
		else{
			transactionEntity.setSellBuyFlg(this.SELL);		
			this.updateTransaction(transactionEntity);
		}
		
	}*/
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TransactionEntity> fetchTransactions(Map<String,Integer> orderBy){
		
		debugLogger.debug("Get List of all transaction from DB by given order -- fetchTransactions from SaleTransactionDaoImpl");
		int size = orderBy.size();
		Criteria transactionCriteria = getSession().createCriteria(TransactionEntity.class);
		transactionCriteria.add(Restrictions.eq("sellBuyFlg", 1));
		
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
