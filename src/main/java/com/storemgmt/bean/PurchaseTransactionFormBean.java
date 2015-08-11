package com.storemgmt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.storemgmt.model.InventoryEntity;
import com.storemgmt.model.TransactionEntity;

@Component("TransactionFormBean")
@Scope(value = "prototype")
public class PurchaseTransactionFormBean {

	PurchaseTransactionFormBean() {
		supplierName = new String();
		itemList = new ArrayList<InventoryFormBean>();
	}

	private int txnId;
	
	@NotBlank
	@Digits(integer = 5,fraction = 0)
	private int supplierId;
	private String supplierName;
	
	@NotBlank
	private Date transactionDt;
	@NotBlank
	@Past
	private Date trueDt;
	
	@NotBlank
	@Valid
	private List<InventoryFormBean> itemList;
	private float subTotal;
	private float extra;
	private float total;
	private float txnAmtPaid;
	
	@Autowired
	private TransactionEntity transactionEntity;
	
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getTransactionDt() {
		return transactionDt;
	}
	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}
	public Date getTrueDt() {
		return trueDt;
	}
	public void setTrueDt(Date trueDt) {
		this.trueDt = trueDt;
	}
	public List<InventoryFormBean> getItemList() {
		return itemList;
	}
	public void setItemList(List<InventoryFormBean> itemList) {
		this.itemList = itemList;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	public float getExtra() {
		return extra;
	}
	public void setExtra(float extra) {
		this.extra = extra;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getTxnAmtPaid() {
		return txnAmtPaid;
	}
	public void setTxnAmtPaid(float txnAmtPaid) {
		this.txnAmtPaid = txnAmtPaid;
	}

	public TransactionEntity convertToTransactionEntity()
	{
		transactionEntity.setTxnId(this.getTxnId());
		transactionEntity.setSupplierId(this.getSupplierId());
		transactionEntity.setTrueDt(this.getTrueDt());
		transactionEntity.setTxnDt(this.getTransactionDt());
		transactionEntity.setItemList(this.convertToInventoryEntityList(this.getItemList()));
		transactionEntity.setTxnSubTotal(this.getSubTotal());
		transactionEntity.setTxnExtra(this.getExtra());
		transactionEntity.setTxnTotal(this.getTotal());
		
		return transactionEntity;
		
	}
	
	public List<InventoryEntity> convertToInventoryEntityList(List<InventoryFormBean> itemListIFB)
	{
		List<InventoryEntity> itemList = new ArrayList<InventoryEntity>();
		for(InventoryFormBean inventoryFormBean : itemListIFB)
		{
			itemList.add(inventoryFormBean.convertToInventoryEntity());
		}
		
		return itemList;
	}	
	
	
}
