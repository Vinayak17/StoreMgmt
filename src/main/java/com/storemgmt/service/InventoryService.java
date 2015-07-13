package com.storemgmt.service;

import java.util.List;
import java.util.Map;

import com.storemgmt.model.InventoryEntity;

public interface InventoryService {

	void addInventory(InventoryEntity inventoryEntity);
	
	void updateInventory(InventoryEntity inventoryEntity);
	
	InventoryEntity fetchInventoryItem(InventoryEntity inventoryEntity);
	
	List<InventoryEntity> fetchInventoryList(Map<String,Integer> orderBy);
	
	public List<InventoryEntity> fetchInventoryListA(Map<String, Integer> orderBy);
	
}
