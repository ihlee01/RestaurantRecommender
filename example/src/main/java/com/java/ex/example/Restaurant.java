package com.java.ex.example;

import java.util.ArrayList;

public class Restaurant {
	String bid;
	String name;
	String address;
	ArrayList<String> categories;
	double longitude;
	double latitude;
	double stars;

	public Restaurant(String bid, String name, String address,
			ArrayList<String> categories, double longitude, double latitude,
			double stars) {
		super();
		this.bid = bid;
		this.name = name;
		this.address = address;
		this.categories = categories;
		this.longitude = longitude;
		this.latitude = latitude;
		this.stars = stars;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", Categories: " + categories.toString();
	}

}
