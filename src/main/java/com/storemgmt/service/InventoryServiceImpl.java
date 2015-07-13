package com.storemgmt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storemgmt.dao.InventoryDao;
import com.storemgmt.model.InventoryEntity;

@Service("InventoryServiceImpl")
@Transactional(readOnly = true)
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;
	
	@Transactional(readOnly = false)
	public void addInventory(InventoryEntity inventoryEntity) {
		inventoryDao.addInventory(inventoryEntity);

	}

	@Transactional(readOnly = false)
	public void updateInventory(InventoryEntity inventoryEntity) {

		inventoryDao.updateInvntory(inventoryEntity);
		
	}
	
	public InventoryEntity fetchInventoryItem(InventoryEntity inventoryEntity) {

		return inventoryDao.fetchInventoryItem(inventoryEntity);
	}

	public List<InventoryEntity> fetchInventoryList(Map<String,Integer> orderBy) {

		
		return (List<InventoryEntity>)inventoryDao.fetchInventoryList(orderBy);
	}

	public List<InventoryEntity> fetchInventoryListA(
			Map<String, Integer> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

}
