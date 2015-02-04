package com.example.eeeee;

public class FoodDetails {

	private String foodName;
	private Integer price;
	private Integer quantity;
	private String orderId;
	private String username;

	public FoodDetails() {
	}
	public FoodDetails(String foodName,Integer price,Integer quantity) {
		this.foodName=foodName;
		this.price=price;
		this.quantity=quantity;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


}
