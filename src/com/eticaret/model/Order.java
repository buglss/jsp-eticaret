package com.eticaret.model;

import java.io.InputStream;

public class Order {

	private int id;
	private String name;
	private String description;
	private float price;
	private int total;
	private String image;
	private int category_id;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String name, String description, float price, int total, String image, int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.total = total;
		this.image = image;
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCategoryId() {
		return category_id;
	}

	public void setCategoryId(int category_id) {
		this.category_id = category_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	
}
