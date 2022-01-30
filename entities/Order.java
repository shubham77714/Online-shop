package oops.exercises.online_shop.entities;

import java.util.Arrays;

public class Order {
	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER=16;
	
	private String creditCardNumber;
	private Product[] products;
	private int customerId;
	
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER &&
					!creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber)>0;
	}
	
	public void setCreditCardNumber(String creditCardNumber) {
		if(creditCardNumber == null)
			return;
		this.creditCardNumber=creditCardNumber;
	}
	
	public void setProducts(Product[] products) {
		this.products=products;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	
	public int getCustomerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
				"credit card number - " + this.creditCardNumber + "\t" + 
				"products - " + Arrays.toString(this.products);
	}
}
