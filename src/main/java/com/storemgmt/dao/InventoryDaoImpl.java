package com.storemgmt.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.SQLCriterion;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.InventoryEntity;

@Repository("InventoryDaoImpl")
public class InventoryDaoImpl extends AbstractDao implements InventoryDao {
	
	private static final Logger  debuglog = Logger.getLogger("debugLogger");

	public void addInventory(InventoryEntity inventoryEntity) {
	
		debuglog.debug("addInventory(InventoryEntity inventoryEntity) from InventoryDaoImpl  -- inserting a product to inventory");
		save(inventoryEntity);
	}

	public void updateInvntory(InventoryEntity inventoryEntity) {
		
		debuglog.debug("updateInvntory(InventoryEntity inventoryEntity) from InventoryDaoImpl  -- updating a product in inventory");
		getSession().update(inventoryEntity);
	}

	public InventoryEntity fetchInventoryItem(InventoryEntity inventoryEntity) {
		
		debuglog.debug("fetchInventoryItem(InventoryEntity inventoryEntity) from InventoryDaoImpl  -- fetch single product from inventory");
		return (InventoryEntity) getSession().get(InventoryEntity.class, inventoryEntity.getInventId());
	}

	@SuppressWarnings("unchecked")
	public List<InventoryEntity> fetchInventoryList(Map<String, Integer> orderBy) {
		
		debuglog.debug("addInventory(InventoryEntity inventoryEntity) from InventoryDaoImpl  -- inserting a product to inventory");
		Criteria inventoryCriteria = getSession().createCriteria(InventoryEntity.class);
		
		inventoryCriteria.setProjection(Projections.projectionList()
		.add(Projections.property("prodName"),"prodName")
		.add(Projections.property("mfgName"),"mfgName")
		.add(Projections.property("ppu"),"ppu")
		.add(Projections.sqlProjection("sum(if(cr_dr_flag = 1,(qty),(qty*-1))) as qty",new String[]{ "qty"},new Type[] {StandardBasicTypes.INTEGER}))
		.add(Projections.groupProperty("prodId"))
		).setResultTransformer(Transformers.aliasToBean(InventoryEntity.class));
	
		if(orderBy.size() == 0)
			return (List<InventoryEntity>)inventoryCriteria.list();
		else
			return (List<InventoryEntity>)inventoryCriteria.list();
	}
	
	public List<InventoryEntity> fetchInventoryListA(Map<String, Integer> orderBy) {
		
		debuglog.debug("addInventory(InventoryEntity inventoryEntity) from InventoryDaoImpl  -- inserting a product to inventory");
		Criteria inventoryCriteria = getSession().createCriteria(InventoryEntity.class);
		
		inventoryCriteria.setProjection(Projections.projectionList()
		.add(Projections.property("prodId"),"prodId")
		.add(Projections.property("invTxnDt"),"invTxnDt")
		.add(Projections.property("ppu"),"ppu")
		.add(Projections.sqlProjection("sum(if(i.cr_dr_flag = 1,(i.qty),(i.qty*-1)))",new String[]{ "Sum"},new Type[] {StandardBasicTypes.INTEGER}))
		.add(Projections.groupProperty("prodId")))
		.setResultTransformer(Transformers.aliasToBean(InventoryEntity.class));
	
		if(orderBy.size() == 0)
			return (List<InventoryEntity>)inventoryCriteria.list();
		else
			return (List<InventoryEntity>)inventoryCriteria.list();
	}

	
	

}
