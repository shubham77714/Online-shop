package oops.exercises.online_shop.entities;

import java.util.Arrays;
import java.util.Objects;

public class Cart {
	private static final int DEFAULT_CART_CAPACITY = 10;
	private Product[] products;
	private int lastIndex;
	
	{
		products = new Product[DEFAULT_CART_CAPACITY];
	}
	
	public boolean isEmpty() {
		if(products==null || products.length==0)
			return true;
		
		for(Product product:products) {
			if(product!=null) {
				return false;
			}
		}
		return true;
	}
	
	public void addProduct(Product product) {
		if(product==null)
			return;
		
		if(products.length<=lastIndex) {
			products = Arrays.copyOf(products, products.length + DEFAULT_CART_CAPACITY);
		}
		products[lastIndex++]=product;
	}
	
	public Product[] getProducts() {
		return Arrays.stream(products).filter(Objects::nonNull).toArray(Product[]::new);
	}
	
//	public Product[] getProducts() {
//		int nonNullProductsAmount = 0;
//		for (Product product : products) {
//			if (product != null) {
//				nonNullProductsAmount++;
//			}
//		}
//		
//		Product[] nonNullProducts = new Product[nonNullProductsAmount];
//		int index = 0;
//		for (Product product : products) {
//			if (product != null) {
//				nonNullProducts[index++] = product;
//			}
//		}
//		
//		return nonNullProducts;
//	}
	 
	public void clear() {
		products= new Product[DEFAULT_CART_CAPACITY];
	}
}
