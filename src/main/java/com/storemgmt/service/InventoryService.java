package com.storemgmt.service;

import java.util.List;

import com.storemgmt.model.InventoryEntity;

public interface InventoryService {

	void createTransaction(InventoryEntity inventoryEntity);
	
	void updateTransaction(InventoryEntity inventoryEntity);
	
	InventoryEntity fetchTransaction(InventoryEntity inventoryEntity);
	
	List<InventoryEntity> fetchTransactions();

}
