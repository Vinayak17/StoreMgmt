package com.storemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.storemgmt.model.ProductType;
import com.storemgmt.service.ProductService;

@Entity(name = "ProductEntity")
@Table(name = "PRODUCT_DETAILS")
public class ProductEntity implements IAuditable{
	
	@Id
	//@Digits(integer = 4,fraction = 0)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="prod_id", nullable = false)
	protected long prodId;
	
	@Column(name = "prod_barcode")
	protected long barCode;
	
	//@Digits(integer = 1,fraction=0)
	@ManyToOne
	@JoinColumn(name = "prod_type")
	//@Enumerated(EnumType.STRING)
	protected ProductType prodType;
	
	//@Digits(integer = 1,fraction=0)
	@ManyToOne
	@JoinColumn(name = "prod_sub_type")
	protected ProductSubType prodSubType;
	
	@Column(name = "prod_name")
	protected String prodName;
	
	@Column(name = "prod_desc" )
	protected String prodDesc;

	@Column(name = "profit_percentage")
	protected float profitPer;
	
	@Column(name = "prod_Entry_dt")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	protected LocalDate prodEntryDate;
	
	@Column(name = "prod_usg_flg")
	protected byte prodUsgFlg;
	
	@Column(name = "created_by")
	protected String createdBy;
	
	@Column(name = "created_on")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	protected LocalDate createdOn;
	
	@Column(name = "updated_by")
	protected String updatedBy;
	
	@Column(name = "updated_on")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	protected LocalDate updatedOn;
	
	
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

	public ProductType getProdType() {
		return prodType;
	}

	public void setProdType(ProductType prodType) {
		this.prodType = prodType;
	}

	public ProductSubType getProdSubType() {
		return prodSubType;
	}

	public void setProdSubType(ProductSubType prodSubType) {
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

	public LocalDate getProdEntryDate() {
		return prodEntryDate;
	}

	public void setProdEntryDate(LocalDate prodEntryDate) {
		this.prodEntryDate = prodEntryDate;
	}

	public float getProfitPer() {
		return profitPer;
	}

	public void setProfitPer(float profitPer) {
		this.profitPer = profitPer;
	}
	
	public byte getProdUsgFlg() {
		return prodUsgFlg;
	}

	public void setProdUsgFlg(byte prodUsgFlg) {
		this.prodUsgFlg = prodUsgFlg;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
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

	public long getId() {
		// TODO Auto-generated method stub
		return getProdId();
	}

	public String getLogDetail() {
		// TODO Auto-generated method stub
		return toString();
	}
}
