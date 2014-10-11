package com.java.ex.example;

public class Review {
	private String rid;
	private String uid;
	private String bid;
	private double star;
	private String text;

	public Review(String uid, String bid, double star, String text) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.bid = bid;
		this.star = star;
		this.text = text;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "User: " + uid + " rated " + bid + " as " + star;
	}

}
