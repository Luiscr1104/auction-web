package com.example.demo.entity;

public class Item {
	private String name;
	private int price;
	private Seller seller;

	public Item(String name, int price, Seller seller) {
		this.name = name;
		this.price = price;
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}
