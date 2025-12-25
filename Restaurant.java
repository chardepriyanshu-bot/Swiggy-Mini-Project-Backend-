package com.project.Swiggy;

public class Restaurant {
	private String restaurantName;
	private String[] menuList;
	
	public Restaurant() {
		restaurantName="Unknown";
	}
	
	public Restaurant(String restaurantName,String[] menu) {
		this.restaurantName=restaurantName;
		menuList=new String[menu.length];
		setMenu(menu);
	}
	public void setMenu(String[] menu) {
		if(menu.length==0) {
			System.err.println("Menu list is empty.");
			System.exit(0);
		}
		for(int i=0;i<menu.length;i++) {
			menuList[i]=menu[i];
		}
	}
	public void showMenu(String [] menu) {
		for(int i=0;i<menu.length;i++) {
			if(menu[i]!=null) {
				System.out.println(i+1+"). "+menu[i]);
				
			}
		}
	}

}
