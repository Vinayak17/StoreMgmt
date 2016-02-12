package com.storemgmt.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import com.storemgmt.model.ProductEntity;
import com.storemgmt.model.ProductSubCategoryEntity;
import com.storemgmt.model.ProductCategoryEntity;

//@Component("ProductFormBean")
//@Scope("prototype")   *** Only the stateless beans should be spring managed bean**
public class ProductFormBean {
	
	
	protected long prodId;
	
	@Min(value = 4 , message = "Barcode huhuh")
	protected long barCode;
	
	protected int prodCategory;
	
	protected int prodSubCategory;
	
	@NotBlank
	protected String prodName;
	
	@NotEmpty
	protected String prodDesc;
	
	protected LocalDate prodEntryDate;
	
	protected byte prodUsgFlg;
	
	private String productCategoryName;
	
	private String productSubCategoryName;
	
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

	public int getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(int prodType) {
		this.prodCategory = prodType;
	}

	public int getProdSubCategory() {
		return prodSubCategory;
	}

	public void setProdSubCategory(int prodSubType) {
		this.prodSubCategory = prodSubType;
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
	
	
	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productTypeName) {
		this.productCategoryName = productTypeName;
	}

	public String getProductSubCategoryName() {
		return productSubCategoryName;
	}

	public void setProductSubCategoryName(String productSubTypeName) {
		this.productSubCategoryName = productSubTypeName;
	}

	public ProductEntity toProductEntity(ProductEntity productEntity)
	{	
		if(getBarCode() != 0)
			productEntity.setBarCode(this.getBarCode());
		if(getProdDesc() != null)
			productEntity.setProdDesc(this.getProdDesc());
		if(getProdEntryDate() != null)
			productEntity.setProdEntryDate(this.getProdEntryDate());
		if(getProdId() != 0)
			productEntity.setProdId(this.getProdId());
		if(getProdName() != null)
			productEntity.setProdName(this.getProdName());
		if(getProdUsgFlg() != 0)
			productEntity.setProdUsgFlg(this.getProdUsgFlg());
		if(getProdCategory() != 0)
		{
			ProductCategoryEntity selectedProductType = new ProductCategoryEntity();
			selectedProductType.setCategoryId(getProdCategory());
			productEntity.setProdType(selectedProductType);
		}
		
		if(getProdSubCategory() != 0)
		{
			ProductSubCategoryEntity selectedProductSubType = new ProductSubCategoryEntity();
			selectedProductSubType.setSubCategoryId(getProdSubCategory());
			productEntity.setProdSubType(selectedProductSubType);
		}
		
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
		productFormBean.setProdUsgFlg(productEntity.getProdUsgFlg());
		productFormBean.setProdCategory(productEntity.getProdType().getCategoryId());
		productFormBean.setProdSubCategory(productEntity.getProdSubType().getSubCategoryId());
		
		productFormBean.setProductCategoryName(productEntity.getProdType().getCategoryName());
		productFormBean.setProductSubCategoryName(productEntity.getProdSubType().getSubCategoryName());
		
		return productFormBean;
	}
}
