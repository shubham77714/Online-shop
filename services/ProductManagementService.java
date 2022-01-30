package oops.exercises.online_shop.services;

import oops.exercises.online_shop.entities.Product;

public class ProductManagementService {
	private static ProductManagementService instance;
	private static Product[] products;
	
	static {
		initProducts();
	}
	
	private static void initProducts() {
		products = new Product[] {
				new Product(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
				new Product(2, "Oregon Cottage Interior Oak Door", "Doors", 179.99),
				new Product(3, "Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
				new Product(4, "4 Panel Oak Deco Interior Door", "Doors", 209.09),
				new Product(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
				new Product(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
				new Product(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
				new Product(8, "Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
				new Product(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
				new Product(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
		};
	}
	
	public ProductManagementService() {
	}
	
	public static ProductManagementService getInstance() {
		if(instance==null) {
			instance=new ProductManagementService();
		}
		return instance;
	}
	
	public Product[] getProducts() {
		return products;
	}
	
	public Product getProductById(int id) {
		for(Product product:products) {
			if(product.getId()==id)
				return product;
		}
		return null;
	}
	
	
}
