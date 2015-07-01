package com.storemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.InventoryDao;
import com.storemgmt.model.InventoryEntity;

public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;
	
	@Transactional
	public void createTransaction(InventoryEntity inventoryEntity) {
		inventoryDao.addInventory(inventoryEntity);

	}

	@Transactional
	public void updateTransaction(InventoryEntity inventoryEntity) {

		inventoryDao.updateInvntory(inventoryEntity);
		
	}

	@Transactional
	public InventoryEntity fetchTransaction(InventoryEntity inventoryEntity) {

		return inventoryDao.fetchInventoryItem(inventoryEntity);
	}

	@Transactional
	public List<InventoryEntity> fetchTransactions() {

		return inventoryDao.fetchInventoryList();
	}

}
