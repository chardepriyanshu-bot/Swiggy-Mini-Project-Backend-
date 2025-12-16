package com.project.Swiggy;

import java.util.Arrays;
import java.util.Scanner;

public class SwiggyUserManagement {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer name:");
		String customerName=sc.nextLine();
		System.out.println("Enter customer mobile number:");
		String mobileNumber=sc.nextLine();
		System.out.println("Enter customer address:");
		String customerAddress=sc.nextLine();
		
		Customer customer=new Customer(customerName,mobileNumber,customerAddress);
		System.out.println("Select Restaurant: "
				+ "1. Food Hub\n"
				+ "2. Spice Villa");
		System.out.print("Choice:");
		String restaurantName="";
		int restaurantInput=Integer.parseInt(sc.nextLine());
		switch(restaurantInput) {
		case 1: 
			restaurantName="Food Hub";
			break;
		case 2: 
			restaurantName="Spice Villa";
			break;
		default:
			System.out.println("Invalid Item number.");
			break;
		}
		int count=0;
		int index=0;
		FoodItem[] orderArr=new FoodItem[3];
		do {
			System.out.println("Select Items:"
					+ "1. Burger - Rs. 120\n"
					+ "2. Pizza - Rs. 250");
			System.out.println("Enter item choice:");
			int itemChoice=Integer.parseInt(sc.nextLine());
			System.out.println("Enter quantity:");
			int quantity=Integer.parseInt(sc.nextLine());
			String putFood="";
			double putPrice=0.0;
			switch(itemChoice) {
			case 1: 
				putFood="Burger";
				putPrice=120.0;
				break;
			case 2: 
				putFood="Pizza";
				putPrice=250.0;
				break;
			default:
				System.out.println("Invalid Item number.");
				break;
			}
			FoodItem foodItem=new FoodItem(putFood,putPrice,quantity);
			
			if(index==orderArr.length) {
				System.out.println("You reach your order limit.");
			}
			else {
				if(orderArr[index]==null) {
					orderArr[index]=foodItem;
					index++;
				}
			}
			
			System.out.println("Do you want to add more?(Yes/No)");
			System.out.println("Enter:");
			String wishInput=sc.nextLine();
			if(wishInput.equalsIgnoreCase("Yes")) {
				count=1;
			}
			else {
				System.out.println("Your order will reach to you very soon.");
				count=0;
			}
		}while(count!=0);
		
		System.out.println(Arrays.toString(orderArr));
		
		Restaurant restaurant =new Restaurant(restaurantName,orderArr);
		restaurant.displayMenu();
		
		OrderManagement order=new OrderManagement(orderArr,"Preparing");
		double totalAmount=order.calculate();
		order.displayOrderDetails();
		System.out.println("Select payment option:"
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
			System.out.println("Invalid Payment Number.");
			break;
		}
		sc.close();
	}

}
