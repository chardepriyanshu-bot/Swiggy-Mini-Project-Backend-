package com.project.Swiggy;

public class FoodItem {
	private String foodItem;
	private double price;
	private int quantity;
	public FoodItem() {
		this.foodItem="Unknown";
		this.price=0.0;
	}
	public FoodItem(String foodItem,double price,int quantity) {
		setFoodItem(foodItem);
		setPrice(price);
		setQuantity(quantity);
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		if(!foodItem.equalsIgnoreCase(null) && !foodItem.isEmpty()) {
			this.foodItem = foodItem;
		}
		else {
			System.out.println("Please check item name.");
			System.exit(0);
		}
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price>0.0) {
			this.price = price;
		}
		else {
			System.out.println("Price should be greater than Rs. 0.0.");
			System.exit(0);
		}
	}
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity>0) {
			this.quantity = quantity;
		}
		else {
			System.out.println("Quantity should be greater than 0.");
			System.exit(0);
		}
	}
	
}
