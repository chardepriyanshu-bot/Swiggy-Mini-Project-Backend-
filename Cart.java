package com.project.Swiggy;

public class Cart {
	protected int cartSize;
	protected FoodItem [] cartArr;
	protected int index=0;
	public Cart(int cartSize){
		super();
		this.cartSize=cartSize;
		cartArr=new FoodItem[cartSize];
	}
	
	public void addCart(FoodItem foodItem) {
		boolean isEqual=false;
		
		for(int i=0;i<cartArr.length;i++) { /*Here If any same item order twice time then just
			 add quantity not item again.*/
				
			   if(cartArr[i]==null) {
				   break;
			   }
			    if(foodItem.getFoodItem().equals(cartArr[i].getFoodItem())) {
				   cartArr[i].quantity=(int) (cartArr[i].quantity+foodItem.getQuantity());
					isEqual=true;
			   	}
			}
		if(index==cartArr.length) {
			System.err.println("You reach your order limit.");
		}
		else {
			if(cartArr[index]==null && isEqual==false) {
				cartArr[index]=foodItem;
				index++;
			}
			 
		}
	}
	
	public void deleteItemFromCart(String foodItem) {
		int index=0;
		boolean isFound=false;
		for (int i=0;i<cartArr.length;i++) {
			if(cartArr[i]!=null && foodItem.equalsIgnoreCase(cartArr[i].getFoodItem())) {
				cartArr[i]=null;
				isFound=true;
				index=i;
				System.out.println("Removed.");
			}
		}
		if(isFound) {
			for(int i=index;i<cartArr.length-1;i++) {
					cartArr[i]=cartArr[i+1];
			}
		}
		else {
			System.err.println("Item is not available in your cart.");
		}
	}
	
	public void displayCart() {
		if(cartArr.length==0) {
			System.err.println("Your cart is Empty.");
			System.exit(0);
		}
		for (FoodItem item: cartArr) {
			if(item!=null) {
				System.out.println("Food Name: "+item.getFoodItem());
				System.out.println("Food Quantity: "+item.getFoodItem());
				System.out.println("Food Price: "+item.getQuantity());
				System.out.println();
			}
			
		}
	}
	
}
