package com.storemgmt.constants;

public enum EnumProductType {
	
	TYPE1("type 1"),
	TYPE2("type 2");
	
	private final String value;
	
	private EnumProductType(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
}
