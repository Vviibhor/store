package com.assignment.springboot.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection= "items")
public class FoodEntity {

	@Id
	private int prodId;
	private String prodName;
	private String prodUrl;
	private String prodPrice;
	private boolean inCart;
	private String prodDescription;
	
	
	
	
	
	
	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public boolean isInCart() {
		return inCart;
	}

	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}

	

	public FoodEntity() {	}

	public int getProdId() {
		return prodId;
	}
	public void setProdId(int id) {
		this.prodId = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String name) {
		this.prodName = name;
	}
	public String getProdUrl() {
		return prodUrl;
	}
	public void setProdUrl(String designation) {
		this.prodUrl = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + prodId + ", name=" + prodName + ", description=" + prodDescription + "]";
	}
}