package com.storemgmt.bean;

import java.util.Date;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.storemgmt.model.InventoryEntity;

@Component("InventoryFormBean")
@Scope(value = "prototype")
public class InventoryFormBean {

	public InventoryFormBean()
	{
		prodName = new String();
		mfgName = new String();
	}
	
	private int inventId;
	private Date inventTxnDt;
	
	
	private String prodName;
	
	@NotBlank
	@Digits(integer = 5, fraction = 0)
	private int prodId;
	
	private String mfgName;
	
	@NotBlank
	@Digits(integer = 5, fraction = 0)
	private int mfgId;
	
	@NotBlank
	@Digits(integer = 5, fraction = 0)
	private float ppu;
	private float qty;
	private float taxAmt;
	private float total;
	
	@Autowired
	InventoryEntity inventoryEntity;
	
	
	public int getInventId() {
		return inventId;
	}
	public void setInventId(int inventId) {
		this.inventId = inventId;
	}
	
	public Date getInventTxnDt() {
		return inventTxnDt;
	}
	public void setInventTxnDt(Date inventTxnDt) {
		this.inventTxnDt = inventTxnDt;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getMfgName() {
		return mfgName;
	}
	public void setMfgName(String mfgName) {
		this.mfgName = mfgName;
	}
	public int getMfgId() {
		return mfgId;
	}
	public void setMfgId(int mfgId) {
		this.mfgId = mfgId;
	}
	public float getPpu() {
		return ppu;
	}
	public void setPpu(float ppu) {
		this.ppu = ppu;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public float getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
		
}

