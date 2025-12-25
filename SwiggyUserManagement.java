package com.project.Swiggy;

import java.util.Scanner;

public class SwiggyUserManagement {

	public static void showRestaurant(String [] restaurant) {
		for(int i=0;i<restaurant.length;i++) {
			if(restaurant[i]!=null) {
				System.out.println(i+1+"). "+restaurant[i]);
				
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("--- Welcome to Swiggy Application ----");
		System.out.println("Enter customer name:");
		String customerName=sc.nextLine();
		System.out.println("Enter customer mobile number:");
		String mobileNumber=sc.nextLine();
		System.out.println("Enter customer address:");
		String customerAddress=sc.nextLine();
		
		Customer customer=new Customer(customerName,mobileNumber,customerAddress);
		String restaurantList[]= {"Food Hub","Spice Villa"};
		
		String[] menu1= {"Panner kadhai - Rs-210", "Masala Panner - Rs-200","Kolhapuri Panner - Rs-190","Butter nan - Rs-50"};
		String[] menu2= {"Chicken Masala - Rs-190", "Hyd Biryani - Rs-250","Lucknow biryani - Rs-190","Butter nan - Rs-50"};

		System.out.println("Select Restaurant:");	
		showRestaurant(restaurantList);
		
		System.out.print("Choice:");
		String restaurantName="";
		int restaurantInput=Integer.parseInt(sc.nextLine());
		switch(restaurantInput) {
		case 1: 
			restaurantName="Food Hub";
			Restaurant restaurant =new Restaurant(restaurantName,menu1);
			restaurant.showMenu(menu1);
			break;
		case 2: 
			restaurantName="Spice Villa";
			Restaurant restaurant2 =new Restaurant(restaurantName,menu2);
			restaurant2.showMenu(menu2);
			break;
		default:
			System.err.println("Invalid Item number.");
			break;
		}
		int count=0;
		Cart cart=new Cart(5);
		do {
			
			System.out.println("Select Items:");
			System.out.println("Enter item choice:");
			int itemChoice=Integer.parseInt(sc.nextLine());
			System.out.println("Enter quantity:");
			int quantity=Integer.parseInt(sc.nextLine());
			FoodItem food = null;

			if(restaurantInput==1) {
				switch(itemChoice) {
				case 1-> food=new FoodItem("Panner kadhai",210.0,quantity);					 
					
				case 2-> food=new FoodItem("Masala Panner",200.0,quantity);
					
				case 3-> food=new FoodItem("Kolhapuri Panner",190.0,quantity);
 
				case 4-> food=new FoodItem("Butter nan",50.0,quantity);
 	
				default->System.err.println("Invalid Item number.");
					
				}
			}
			else if(restaurantInput==2) {
				switch(itemChoice) {
				case 1 ->food=new FoodItem("Chicken Masala",190.0,quantity);
 
				case 2 ->food=new FoodItem("Hyd Biryani",250.0,quantity);
 
				case 3 ->food=new FoodItem("Lucknow Biryani ",200.0,quantity);

				case 4 ->food=new FoodItem("Butter nan",50.0,quantity);
 
				default->System.err.println("Invalid Item number.");
					
				}
			}
			FoodItem foodItem=new FoodItem(food.getFoodItem(),food.getPrice(),food.getQuantity());
			cart.addCart(foodItem);
			
			System.out.println("Do you want to add more?(Yes/No)");
			System.out.println("Enter:");
			String wishInput=sc.nextLine();
			if(wishInput.equalsIgnoreCase("Yes")) {
				count=1;
			}
			else {
				//System.out.println("Your order will reach to you very soon.\n");
				count=0;
			}
		}while(count!=0);
		
		int out=0;
		do {
			System.out.println("Do you want to see your cart?"
					+ "\n1. My Cart"
					+ "\n2. Delete");
			System.out.println("Enter:");
			int cartWish=Integer.parseInt(sc.nextLine());
			switch(cartWish) {
			case 1: cart.displayCart();break;
			
			case 2: System.out.println("Enter item name: ");
			String deleteItem=sc.nextLine();
			cart.deleteItemFromCart(deleteItem);break; 
			
			default:
				break;
				}
			System.out.println("Do you want to see again your cart??"
					+ "\n1.Yes"
					+ "\n2.No");
			System.out.println("Enter: ");
			String input=sc.nextLine();
			switch(input.toLowerCase()) {
			case "yes"->out=1;
			case "no" -> out=0;
			}
		}while(out!=0);
		
		//restaurant.displayMenu();
		
		OrderManagement order=new OrderManagement(customer,cart.cartArr);
		double totalAmount=order.calculate();
		order.displayOrderDetails();
		System.out.println("\nSelect payment option:"
				+ "\n1.UPI Payment"
				+ "\n2.Card Payment");
		System.out.println("Enter the choice:");
		int payInput=Integer.parseInt(sc.nextLine());
		switch(payInput) {
		case 1:
			Payment upi=new UPIPayment();
			System.out.println("Enter pay amount:");
			double tempPay=Double.parseDouble(sc.nextLine());
			upi.validate(totalAmount, tempPay);
			upi.pay(tempPay);
			break;
		case 2:
			Payment card=new CardPayment();
			System.out.println("Enter pay amount:");
			double cardPay=Double.parseDouble(sc.nextLine());
			card.validate(totalAmount, cardPay);
			card.pay(cardPay);
			break;
		default:
			System.err.println("Invalid Payment Number.");
			break;
		}
		sc.close();
		
		
	}

}
