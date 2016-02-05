package com.storemgmt.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import com.storemgmt.model.ProductEntity;
import com.storemgmt.model.ProductSubType;
import com.storemgmt.model.ProductType;

//@Component("ProductFormBean")
//@Scope("prototype")   *** Only the stateless beans should be spring managed bean**
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

	public ProductEntity toProductEntity(ProductEntity productEntity)
	{		
		productEntity.setBarCode(this.getBarCode());
		productEntity.setProdDesc(this.getProdDesc());
		productEntity.setProdEntryDate(this.getProdEntryDate());
		productEntity.setProdId(this.getProdId());
		productEntity.setProdName(this.getProdName());
		//productEntity.setProdEntryDate(this.getProdEntryDate());
		productEntity.setProdUsgFlg(this.getProdUsgFlg());
		ProductType selectedProductType = new ProductType();
		selectedProductType.setType_id(getProdType());
		ProductSubType selectedProductSubType = new ProductSubType();
		selectedProductSubType.setSubTypeId(getProdSubType());
		productEntity.setProdType(selectedProductType);
		productEntity.setProdSubType(selectedProductSubType);
		
		return productEntity;
	}
	
	public static ProductFormBean toProductFormBean(ProductEntity productEntity)
	{
		ProductFormBean productFormBean = new ProductFormBean();
		productFormBean.setBarCode(productEntity.getBarCode());
		productFormBean.setProdDesc(productEntity.getProdDesc());
		productFormBean.setProdEntryDate(productEntity.getProdEntryDate());
		productFormBean.setProdId(productEntity.getProdId());
		productFormBean.setProdName(productEntity.getProdName());
		//productEntity.setProdEntryDate(this.getProdEntryDate());
		productFormBean.setProdUsgFlg(productEntity.getProdUsgFlg());
		productFormBean.setProdType(productEntity.getProdType().getType_id());
		productFormBean.setProdSubType(productEntity.getProdSubType().getSubTypeId());
		
		return productFormBean;
	}
}
