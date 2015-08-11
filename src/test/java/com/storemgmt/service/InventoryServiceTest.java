package com.storemgmt.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.storemgmt.config.SpringConfig;
import com.storemgmt.model.InventoryEntity;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class InventoryServiceTest {

	//@Autowired
	InventoryService inventoryServiceImpl;
	
	//@Test
	public void test() {
		
		for(InventoryEntity inventoryEntity : (List<InventoryEntity>)inventoryServiceImpl.fetchInventoryList(new HashMap<String,Integer>()))
		{
			System.out.println(inventoryEntity);
		}
		
		
	}

}
