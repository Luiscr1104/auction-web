package com.example.demo.entity;

public class Bid {
	private Bidder bidder;
	private Item item;
	private int startBid;
	private int maxBid;
	private int autoIncrementAmount;

	public Bid(Bidder bidder, Item item, int startBid, int maxBid, int autoIncrementAmount) {
		this.bidder = bidder;
		this.item = item;
		this.startBid = startBid;
		this.maxBid = maxBid;
		this.autoIncrementAmount = autoIncrementAmount;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getStartBid() {
		return startBid;
	}

	public void setStartBid(int startBid) {
		this.startBid = startBid;
	}

	public int getMaxBid() {
		return maxBid;
	}

	public void setMaxBid(int maxBid) {
		this.maxBid = maxBid;
	}

	public int getAutoIncrementAmount() {
		return autoIncrementAmount;
	}

	public void setAutoIncrementAmount(int autoIncrementAmount) {
		this.autoIncrementAmount = autoIncrementAmount;
	}

}
