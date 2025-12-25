package com.project.Swiggy;

public class FoodItem {
	
	public String foodItem;  //declare non-static variable for foodItem which has public access modifier and String data type.
	public double price;		//declare non-static variable for price which has public access modifier and double data type.
	public int quantity;    //declare non-static variable for quantity which has public access modifier and int data type.
	public FoodItem() {    
		 //Non parameterized constructor to provide readable value to non static variable as per their data type.
		this.foodItem="Unknown";
		this.price=0.0;
	}
	public FoodItem(String foodItem,double price,int quantity) {
		//Here provided parameterized constructor to load the non-static variable or initialized variable.
		setFoodItem(foodItem);  // calling setFoodItem with passing argument to set the non-static variable with validation.
		setPrice(price);			// calling setPrice with passing argument to set the non-static variable with validation.
		setQuantity(quantity);  // calling setQuantity with passing argument to set the non-static variable with validation.
	}
	public String getFoodItem() {
	//getFoodItem() is non-static method with non-parameter which have public access modifier with return type is String.
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		//setFoodItem() is non-static method with parameter which has public access modifier with no return any value .
		if(!foodItem.equalsIgnoreCase(null) && !foodItem.isEmpty()) {   //checking foodItem is equal null && empty or not.
			this.foodItem = foodItem;     //if condition is true then initialize current object foodItem from local variable fooditem.
		}
		else {
			//If condition is false then print message and exit from the program.
			System.err.println("Please check item name.");
			System.exit(0);  //it is used to terminate from the program.
		}
	}
	public double getPrice() {
		//getPrice() is non-static method with non-parameter which has public access modifier with return type is double.
		return price;
	}
	public void setPrice(double price) {
		//setFoodItem() is non-static method with parameter which has public access modifier with no return any value .
		if(price>0.0) {   //checking condition for price should be greater than zero
			this.price = price;  //if condition is true then initialize current object price from local variable price.
		}
		else {
			//If condition is false then print message and exit from the program.
			System.err.println("Price should be greater than Rs. 0.0.");
			System.exit(0);   //it is used to terminate from the program.
		}
	}
	
	public int getQuantity() {
		//getQuantity() is non-static method with non-parameter which has public access modifier with return type is double.
		return quantity;
	}
	public void setQuantity(int quantity) {
		//setQuantity() is non-static method with parameter which has public access modifier with no return any value .
		if(quantity>0) {  //checking quantity is greater than zero or not.
			this.quantity = quantity;    //if condition is true then initialize current object quantity from local variable quantity.
		}
		else {
			//If condition is false then print message and exit from the program.
			System.err.println("Quantity should be greater than 0.");
			System.exit(0);   //it is used to terminate from the program.
		}
	}
	
}
