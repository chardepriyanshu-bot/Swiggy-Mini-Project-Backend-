package com.project.Swiggy;

import java.util.Random;

public class OrderManagement {
	/*Here declared the non static variable with used of private access modifier to prevent the data from outside world
	or class and data type as per their requirement.*/
	private int orderId;
	private FoodItem [] itemList;
	private double totalBill;
	Customer customer;
	
	public OrderManagement() {
		//Non-parameterized constructor to provide readable value to non static variable as per their data type.
		this.orderId=0;
		this.totalBill=0.0;
	}
	public OrderManagement(Customer customer,FoodItem[] item) {
		/* These is parameterized constructor which has same name as class name 
		 */
		setOrderId();
		itemList=new FoodItem[item.length];
		SetItem(item);
		this.customer=customer;
	}
	
	public void SetItem(FoodItem[] item) {
		if(item.length==0) {
			System.err.println("Menu List is empty.");
			System.exit(0);
		}
		for(int i=0;i<item.length;i++) {
			itemList[i]=item[i];
		}
	}

	public void setOrderId(){
		Random random=new Random();
		this.orderId=random.nextInt() & Integer.MAX_VALUE;
	}

	
	public double calculate() {
		
		for(FoodItem food:itemList) {
			if(food!=null) {
				totalBill+=food.getPrice()*food.getQuantity();
			}
		}
		return totalBill;
	}
	
	public void displayOrderDetails() {
		System.out.println("Order No.: "+orderId);
		System.out.println("Customer Name: "+customer.getUserName());

		for(FoodItem e:itemList) {
			if(e!=null) {
				System.out.println("Food Item Name: "+e.getFoodItem());
				System.out.println("Food Item Price: "+e.getPrice());
				System.out.println("Food Item Quantity: "+e.getQuantity());
				System.out.println();
			}
		}
		System.out.println("Total Bill: "+totalBill);
	}
}
