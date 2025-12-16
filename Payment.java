package com.project.Swiggy;

public interface Payment {
	public abstract void pay(double amount);
	public abstract void validate(double totalAmount,double payAmount);
}
