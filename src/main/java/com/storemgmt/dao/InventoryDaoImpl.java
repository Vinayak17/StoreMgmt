package com.storemgmt.dao;

import java.util.List;

import com.storemgmt.model.InventoryEntity;

public class InventoryDaoImpl extends AbstractDao implements InventoryDao {

	public void addInventory(InventoryEntity inventoryEntity) {
			save(inventoryEntity);
	}

	public void updateInvntory(InventoryEntity inventoryEntity) {
		
		getSession().update(inventoryEntity);
	}

	public InventoryEntity fetchInventoryItem(InventoryEntity inventoryEntity) {
		
		return (InventoryEntity) getSession().get(InventoryEntity.class, inventoryEntity.getInventId());
	}

	@SuppressWarnings("unchecked")
	public List<InventoryEntity> fetchInventoryList() {
		
		return (List<InventoryEntity>) getSession().createCriteria(InventoryEntity.class).list();
	}

}
