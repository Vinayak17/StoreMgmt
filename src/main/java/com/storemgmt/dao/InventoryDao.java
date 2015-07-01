package com.storemgmt.dao;

import java.util.List;

import com.storemgmt.model.InventoryEntity;

public interface InventoryDao {

	void addInventory(InventoryEntity inventoryEntity);
	
	void updateInvntory(InventoryEntity inventoryEntity);
	
	InventoryEntity fetchInventoryItem(InventoryEntity inventoryEntity);
	
	List<InventoryEntity> fetchInventoryList();
	
}
