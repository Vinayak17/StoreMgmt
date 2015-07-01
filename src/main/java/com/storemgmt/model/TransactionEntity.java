package com.storemgmt.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("TransactionEntity")
@Entity(name = "TransactionEntity")
@Table(name = "transactions")
public class TransactionEntity implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "txn_id")
	protected long txnId;
	
	@Column(name = "txn_dt")
	protected Date txnDt;
	
	@Column(name = "true_dt")
	protected Date trueDt;
	
	@Column(name = "cust_id")
	protected long custId;
	
	@Column(name = "user_id")
	protected long userId;
	
	@Column(name = "txn_sub_total")
	protected float txnSubTotal;
	
	@Column(name = "txn_extra")
	protected float txnExtra;
	
	@Column(name = "txn_total")
	protected float txnTotal;
	
	@Column(name = "sell_pur_flag")
	protected int sellPurchaseFlag;
	
	@Column(name = "txn_amt_paid")
	protected float txnAmtPaid;
	
	@Column(name = "txn_stat")
	protected int txnStatus;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "txn_id", nullable = false)
	protected List<InventoryEntity> itemList;
	
	@Column(name = "created_by")
	protected String createdBy;
	
	@Column(name = "created_on")
	protected Date createdOn;
	
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@Column(name = "updated_on")
	protected Date updatedOn;

	
	
	public List<InventoryEntity> getItemList() {
		return itemList;
	}

	public void setItemList(List<InventoryEntity> itemList) {
		this.itemList = itemList;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public Date getTxnDt() {
		return txnDt;
	}

	public void setTxnDt(Date txnDt) {
		this.txnDt = txnDt;
	}

	public Date getTrueDt() {
		return trueDt;
	}

	public void setTrueDt(Date trueDt) {
		this.trueDt = trueDt;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public float getTxnSubTotal() {
		return txnSubTotal;
	}

	public void setTxnSubTotal(float txnSubTotal) {
		this.txnSubTotal = txnSubTotal;
	}

	public float getTxnExtra() {
		return txnExtra;
	}

	public void setTxnExtra(float txnExtra) {
		this.txnExtra = txnExtra;
	}

	public float getTxnTotal() {
		return txnTotal;
	}

	public void setTxnTotal(float txnTotal) {
		this.txnTotal = txnTotal;
	}

	public int getSellPurchaseFlag() {
		return sellPurchaseFlag;
	}

	public void setSellPurchaseFlag(int sellPurchaseFlag) {
		this.sellPurchaseFlag = sellPurchaseFlag;
	}

	public float getTxnAmtPaid() {
		return txnAmtPaid;
	}

	public void setTxnAmtPaid(float txnAmtPaid) {
		this.txnAmtPaid = txnAmtPaid;
	}

	public int getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(int txnStatus) {
		this.txnStatus = txnStatus;
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
		return (int)(this.txnId/10000);
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null || !(obj instanceof TransactionEntity))
			return false;
		else if((obj instanceof TransactionEntity) && ((TransactionEntity)obj).getTxnId() == this.getTxnId())
			return true;
		else 
			return false;
	}
	
	public String toString()
	{
		return " Txn ID : "+ this.getTxnId() +"\n Transaction type: "+ this.getSellPurchaseFlag() +"\n Customer Name: "+
				this.getCustId() + " \n Item List :"+ this.getItemList();
	}
	
}
