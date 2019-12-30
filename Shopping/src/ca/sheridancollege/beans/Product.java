package ca.sheridancollege.beans;
////Mehreen Asif Student ID 991539801

import java.io.Serializable;

public class Product implements Serializable {

	public Product(String productType, double productPrice) {
		super();
		this.productType = productType;
		this.productPrice = productPrice;
	}

	private String productType;
	private double productPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productType=" + productType + ", productPrice=" + productPrice + "]";
	}

}
