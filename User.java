package com.project.Swiggy;

public class User {
	
	private String userName;
	private String mobileNumber;
	private String address;
	
	public User() {
		this.userName ="Unknown";
		this.mobileNumber ="Unknown";
		this.address ="Unknown";
	}
	
	public User(String userName, String mobileNumber, String address) {
		super();
		setUserName(userName);
		setMobileNumber(mobileNumber);
		setAddress(address);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if(!userName.equalsIgnoreCase(null) && !userName.isEmpty()) {
			this.userName = userName;
		}
		else {
			System.err.println("Invalid Name.");
			System.exit(0);
		}
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		if(mobileNumber.length()==10) {
			this.mobileNumber=mobileNumber;
		}
		else {
			System.err.println("Invalid Mobile Number.");
			System.exit(0);
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(!address.equalsIgnoreCase(null) && !address.isEmpty()) {
			this.address = address;
		}
		else {
			System.err.println("Invalid Address.");
			System.exit(0);
		}
	}
	
	public String displayDetails() {
		return "--- Customer Details ---"
				+ "\nCustomer Name: "+userName+
				"\nMobile Numeber: "+mobileNumber+
				"\nAddress: "+address;
	}
	
}
