package com.storemgmt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class CheckEntityManager {

	@Autowired
	TransactionEntity transactionEntity;
	
	@Autowired
	InventoryEntity inventoryEntity;
	
	
	public TransactionEntity getTransactionEntity()
	{
		return transactionEntity;
	}
	
	public InventoryEntity getInventoryEntity()
	{
		return inventoryEntity;
	}
}
