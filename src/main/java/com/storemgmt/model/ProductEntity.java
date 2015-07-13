package com.storemgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.stereotype.Component;

@Component("ProductEntity")
@Entity(name = "ProductEntity")
@Table(name = "PRODUCT_DETAILS")
public class ProductEntity {
	
	@Id
	//@Digits(integer = 4,fraction = 0)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="prod_id", nullable = false)
	protected long prodId;
	
	@Column(name = "prod_barcode")
	protected long barCode;
	
	//@Digits(integer = 1,fraction=0)
	@Column(name = "prod_type")
	protected int prodType;
	
	//@Digits(integer = 1,fraction=0)
	@Column(name = "prod_sub_type")
	protected int prodSubType;
	
	/*@Column(name = "prod_mfg_Id")
	protected int prodMfgId;
	
	@Column(name = "prod_mfg_name")
	protected int prodMfgName;
	*/
	@Column(name = "prod_name")
	protected String prodName;
	
	@Column(name = "prod_desc")
	protected String prodDesc;
	
	@Column(name = "prod_Entry_dt")
	protected Date prodEntryDate;
	
	@Column(name = "prod_usg_flg")
	protected Date prodUsgFlg;
	
	@Column(name = "created_by")
	protected String createdBy;
	
	@Column(name = "created_on")
	protected Date createdOn;
	
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@Column(name = "updated_on")
	protected Date updatedOn;
	

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public long getBarCode() {
		return barCode;
	}

	public void setBarCode(long barCode) {
		this.barCode = barCode;
	}

	public int getProdType() {
		return prodType;
	}

	public void setProdType(int prodType) {
		this.prodType = prodType;
	}

	public int getProdSubType() {
		return prodSubType;
	}

	public void setProdSubType(int prodSubType) {
		this.prodSubType = prodSubType;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public Date getProdEntryDate() {
		return prodEntryDate;
	}

	public void setProdEntryDate(Date prodEntryDate) {
		this.prodEntryDate = prodEntryDate;
	}	
	
	/*public int getProdMfgId() {
		return prodMfgId;
	}

	public void setProdMfgId(int prodMfgId) {
		this.prodMfgId = prodMfgId;
	}

	public int getProdMfgName() {
		return prodMfgName;
	}

	public void setProdMfgName(int prodMfgName) {
		this.prodMfgName = prodMfgName;
	}*/
	
	public Date getProdUsgFlg() {
		return prodUsgFlg;
	}

	public void setProdUsgFlg(Date prodUsgFlg) {
		this.prodUsgFlg = prodUsgFlg;
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
		return (int)(this.prodId/10000);
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null || !(obj instanceof ProductEntity))
			return false;
		else if((obj instanceof ProductEntity) && ((ProductEntity)obj).getProdId() == this.getProdId())
			return true;
		else 
			return false;
	}
	
	public String toString()
	{
		return "Product Name : "+ this.getProdName()+"\n Product type: "+ this.getProdType()+"\n Product Subtype: "+this.getProdSubType()+"\n Product desc: "+this.getProdDesc()+"\n Product Registered: "+this.getProdEntryDate()+"";
	}
}
