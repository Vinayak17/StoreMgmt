package com.storemgmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.storemgmt.model.EntityManager;
import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@Configuration
public class LookUpMethods {

	@Bean
	@Scope(value = "prototye")
	public InventoryEntity getInventoryEntity()
	{		
		return	new InventoryEntity();
	}
	
	@Bean
	public EntityManager entityManager()
	{		
		return new EntityManager(){

			@Override
			public InventoryEntity getInventoryEntity() {
				
				return new InventoryEntity();
			}

			@Override
			public TransactionEntity getTransactionEntity() {
				
				return new TransactionEntity();
			}						 
		};
	}
}
