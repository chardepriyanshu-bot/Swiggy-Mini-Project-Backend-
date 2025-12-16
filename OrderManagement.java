package com.project.Swiggy;

import java.util.Random;

public class OrderManagement {
	 
	public int orderId;
	public FoodItem [] itemList;
	public String orderStatus;
	public double totalBill;
	
	
	public OrderManagement(FoodItem[] item,String orderStatus) {
		setOrderId();
		setOrderStatus(orderStatus);
		itemList=new FoodItem[item.length];
		SetItem(item);
	}
	
	public void SetItem(FoodItem[] item) {
		if(item.length==0) {
			System.out.println("Menu List is empty.");
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
	
	public void setOrderStatus(String orderStatus) {
		if(!orderStatus.isEmpty() && !orderStatus.equalsIgnoreCase(null) && (
				orderStatus.equalsIgnoreCase("Placed") || orderStatus.equalsIgnoreCase("Preparing") 
				|| orderStatus.equalsIgnoreCase("Delivered") 
				)) {
			this.orderStatus=orderStatus;
		}
		else {
			System.out.println("Please check order status.");
			System.exit(0);
		}
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
		System.out.println("Order id: "+orderId);
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
