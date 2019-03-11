package com.capgemini.salesmanagement.beans;

public class Product {
	private int productCode,quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private String productName,productCategory,productDescription; 
	private long productPrice;
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	public Product(int productCode,String productName,String productCatetgory,String productDesc,long productPrice)
	{
		this.productCode=productCode;
		this.productName=productName;
		this.productCategory=productCatetgory;
		this.productDescription=productDesc;
		this.productPrice=productPrice;
	}

}
