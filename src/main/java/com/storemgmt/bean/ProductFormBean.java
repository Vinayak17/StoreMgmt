package com.storemgmt.bean;



import javax.validation.constraints.Min;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.storemgmt.model.ProductEntity;

@Component("ProductFormBean")
@Scope("prototype")
public class ProductFormBean {
	
	
	protected long prodId;
	
	@Min(value = 4 , message = "Barcode huhuh")
	protected long barCode;
	
	protected int prodType;
	
	protected int prodSubType;
	
	@NotBlank
	protected String prodName;
	
	@NotEmpty
	protected String prodDesc;
	
	protected LocalDate prodEntryDate;
	
	protected byte prodUsgFlg;

	protected ProductEntity productEntity;
	
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

	public LocalDate getProdEntryDate() {
		return prodEntryDate;
	}

	public void setProdEntryDate(LocalDate prodEntryDate) {
		this.prodEntryDate = prodEntryDate;
	}

	public byte getProdUsgFlg() {
		return prodUsgFlg;
	}

	public void setProdUsgFlg(byte prodUsgFlg) {
		this.prodUsgFlg = prodUsgFlg;
	}

	public ProductEntity convertProductFormBeanToEntity(ProductFormBean productFormBean)
	{
		productEntity = new ProductEntity();
		productEntity.setBarCode(productFormBean.getBarCode());
		productEntity.setProdDesc(productFormBean.getProdDesc());
		productEntity.setProdEntryDate(productFormBean.getProdEntryDate());
		productEntity.setProdId(productFormBean.getProdId());
		productEntity.setProdName(productFormBean.getProdName());
		//productEntity.setProdEntryDate(productFormBean.getProdEntryDate());
		productEntity.setProdUsgFlg(productFormBean.getProdUsgFlg());
		productEntity.setProdType(productFormBean.getProdType());
		productEntity.setProdSubType(productFormBean.getProdSubType());
		
		return productEntity;
	}
}
