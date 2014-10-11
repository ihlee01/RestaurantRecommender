package com.java.ex.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AppdataGenerator {
	private HashMap<String, User> users = new HashMap<String, User>();
	private HashMap<String, Restaurant> restaurants = new HashMap<String, Restaurant>();
	private HashMap<String, Review> reviews = new HashMap<String, Review>();

	public void getReviews() {
		JSONParser parser = new JSONParser();
		String current;
		BufferedReader br = null;

		try {
			FileReader reader = new FileReader(
					"/Users/ilee/Documents/workspace/example/review.json");
			br = new BufferedReader(reader);
			while ((current = br.readLine()) != null) {
				Object obj;
				try {
					obj = parser.parse(current);
					JSONObject jObject = (JSONObject) obj;

					String rid = (String) jObject.get("review_id");
					String uid = (String) jObject.get("user_id");
					String bid = (String) jObject.get("business_id");
					double stars = (Long) jObject.get("stars");
					String text = (String) jObject.get("text");
					Review review = new Review(uid, bid, stars, text);
					reviews.put(rid, review);
					// System.out.println(reviews.get(rid).toString());
					if (users.get(review.getUid()) != null
							&& restaurants.get(review.getBid()) != null) {
						System.out.println(users.get(review.getUid())
								.getUserName()
								+ " rated "
								+ restaurants.get(review.getBid()).getName()
								+ " as " + review.getStar());
					}

				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	public void getRestaurants() {
		JSONParser parser = new JSONParser();
		String current;
		BufferedReader br = null;

		try {
			FileReader reader = new FileReader(
					"/Users/ilee/Documents/workspace/example/business.json");
			br = new BufferedReader(reader);

			// Read the JSON file line by line
			while ((current = br.readLine()) != null) {
				Object obj;
				try {
					obj = parser.parse(current);
					JSONObject jObject = (JSONObject) obj;
					// Only reading restaurants info
					ArrayList<String> categories = new ArrayList<String>();
					JSONArray categories_array = (JSONArray) jObject
							.get("categories");
					if (categories_array.contains("Restaurants")) {
						// Categories will only contain the category of the
						// restaurant
						categories_array.remove("Restaurants");
						if (categories_array.size() > 0) {
							String bid = (String) jObject.get("business_id");
							String name = (String) jObject.get("name");
							String address = (String) jObject
									.get("full_address");
							Double longitude = (Double) jObject
									.get("longitude");
							Double latitude = (Double) jObject.get("latitude");
							Double stars = (Double) jObject.get("stars");
							for (int i = 0; i < categories_array.size(); i++) {
								categories
										.add((String) categories_array.get(i));
							}
							Restaurant restaurant = new Restaurant(bid, name,
									address, categories, longitude, latitude,
									stars);
							// Generating restaurants list
							restaurants.put(bid, restaurant);
							// System.out.println(restaurant.toString());
						}
					}

				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	public void getUsers() {
		JSONParser parser = new JSONParser();
		String current;
		BufferedReader br = null;

		try {
			FileReader reader = new FileReader(
					"/Users/ilee/Documents/workspace/example/user.json");
			br = new BufferedReader(reader);
			while ((current = br.readLine()) != null) {
				Object obj;
				try {
					obj = parser.parse(current);
					JSONObject jObject = (JSONObject) obj;

					String uid = (String) jObject.get("user_id");
					String name = (String) jObject.get("name");
					Double stars = (Double) jObject.get("average_stars");
					Long review_count = (Long) jObject.get("review_count");
					User user = new User(uid, name, stars, review_count);
					users.put(uid, user);
					// System.out.println(user.toString());

				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AppdataGenerator app = new AppdataGenerator();
		app.getUsers();
		app.getRestaurants();
		app.getReviews();
	}
}
