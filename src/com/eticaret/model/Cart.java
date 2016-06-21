package com.eticaret.model;

import java.util.Date;

public class Cart {
	private int id;
	private String date;
	private String prompt;
	private int total;
	private float price;
	private int user_id;
	private int order_id;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, String date, String prompt, int total, float price, int user_id,
			int order_id) {
		super();
		this.id = id;
		this.date = date;
		this.prompt = prompt;
		this.total = total;
		this.price = price;
		this.user_id = user_id;
		this.order_id = order_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public int getOrderId() {
		return order_id;
	}

	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}

}