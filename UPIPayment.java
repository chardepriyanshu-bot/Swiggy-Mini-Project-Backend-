package com.project.Swiggy;

import java.util.Random;

public class UPIPayment implements Payment {
	
	@Override
	public void pay(double amount) {
			 System.out.println("Payment successfully by using UPI");
			 Long randomValue=new Random().nextLong() & Long.MAX_VALUE;
			 System.out.println("Transaction Id: "+randomValue);
	}

	@Override
	public void validate(double totalAmount,double payAmount) {
		
		if(payAmount==totalAmount) {
			 System.out.println("Amount verified.Now, you can pay..");
		 }
		 else {
			 System.out.println("Payment failed. Invalid amount or payment method");
			 System.exit(0);
		 }
		
	}
}
