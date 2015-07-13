package com.storemgmt.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component("InventoryEntity")
@Entity(name = "InventoryEntity")
@Table(name = "inventory")
public class InventoryEntity implements Auditable {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invent_id")
	protected long inventId;
	
	//@ManyToOne
	//@JoinColumn(name = "txn_id")
	//protected TransactionEntity transactionEntity;
	
	//@Column(name = "txn_id")
	//protected long txnId;
	
	@Column(name = "prod_id")
	protected long prodId;
	
	@Column(name = "prod_name")
	protected String prodName;
	
	@Column(name = "qty")
	protected int qty;
	
	@Column(name = "ppu")
	protected int ppu;
	
	@Column(name = "invent_txn_dt")
	protected Date invTxnDt;
	
	@Column(name = "cr_dr_flag")
	protected int crDrFlag;
	
	@Column(name = "mfg_id")
	protected int mfgId;
	
	@Column(name = "mfg_name")
	protected String mfgName;
	
	@Column(name = "created_by")
	protected String createdBy;
	
	@Column(name = "created_on")
	protected Date createdOn;
	
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@Column(name = "updated_on")
	protected Date updatedOn;
	
		
	public long getInventId() {
		return inventId;
	}

	public void setInventId(long inventId) {
		this.inventId = inventId;
	}

	/*public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}*/

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPpu() {
		return ppu;
	}

	public void setPpu(int ppu) {
		this.ppu = ppu;
	}	

	public int getMfgId() {
		return mfgId;
	}

	public void setMfgId(int mfgId) {
		this.mfgId = mfgId;
	}

	public String getMfgName() {
		return mfgName;
	}

	public void setMfgName(String mfgName) {
		this.mfgName = mfgName;
	}

	public Date getInvTxnDt() {
		return invTxnDt;
	}

	public void setInvTxnDt(Date invTxnDt) {
		this.invTxnDt = invTxnDt;
	}

	public int getCrDrFlag() {
		return crDrFlag;
	}

	public void setCrDrFlag(int crDrFlag) {
		this.crDrFlag = crDrFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int hashCode()
	{
		return (int)(this.inventId/10000);
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null || !(obj instanceof InventoryEntity))
			return false;
		else if((obj instanceof InventoryEntity) && ((InventoryEntity)obj).getInventId() == this.getInventId())
			return true;
		else 
			return false;
	}
	
	public String toString()
	{
		return " Inventory ID : "+ this.getProdName() +"\n Transaction type: "+ this.getMfgName() +"\n Product Name: "+ this.getPpu()+"hello "
				+this.getQty();
	}
}
