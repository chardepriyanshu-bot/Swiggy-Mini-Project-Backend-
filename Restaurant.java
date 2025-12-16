package com.project.Swiggy;

public class Restaurant {
	public String restaurantName;
	public FoodItem[] menuList;
	
	public Restaurant() {
		restaurantName="Unknown";
	}
	
	public Restaurant(String restaurantName,FoodItem[] menu) {
		this.restaurantName=restaurantName;
		menuList=new FoodItem[menu.length];
		setMenu(menu);
	}
	public void setMenu(FoodItem[] menu) {
		if(menu.length==0) {
			System.out.println("Menu list is empty.");
			System.exit(0);
		}
		for(int i=0;i<menu.length;i++) {
			menuList[i]=menu[i];
		}
	}
	
	public void displayMenu() {
		
		System.out.printf("==== %s ====",restaurantName);
		System.out.println("\n--- Menu ---");
		for(FoodItem item:menuList) {
			if(item!=null) {
				System.out.println("Food Name: "+item.getFoodItem());
				System.out.println("Price: "+item.getPrice());
				System.out.println();
			}
			
		}
	}
}
