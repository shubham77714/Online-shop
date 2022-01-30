package oops.exercises.online_shop.entities;

public class Product {
	private int id;
	private String productName;
	private String categoryName;
	private double price;
	public Product() {
	}
	
	public Product(int id,String productName,String categoryName,double price) {
		this.id=id;
		this.productName=productName;
		this.categoryName=categoryName;
		this.price=price;
	}
	public int getId() {
		return this.id;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	@Override
	public String toString() {
		return "Product id=" + id + ", product name=" + productName
				+ ", category name=" + categoryName + ", price=" + price;
	}
	
}
