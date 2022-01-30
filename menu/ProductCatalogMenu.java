package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;
import oops.exercises.online_shop.entities.Cart;
import oops.exercises.online_shop.entities.Product;
import oops.exercises.online_shop.services.ProductManagementService;

public class ProductCatalogMenu implements Menu {
	private static final String CHECKOUT_COMMAND = "checkout";
	
	private ApplicationContext context;
	private ProductManagementService productManagementService;
	
	{
		context = ApplicationContext.getInstance();
		productManagementService = ProductManagementService.getInstance();
	}
	@Override
	public void start() {
		Menu menuToNavigate = null;
		printMenuHeader();
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter product id to add it to the cart "
					+"or enter ‘checkout’ if you want to proceed with checkout."+System.lineSeparator()
					+ "or 'menu' to navigate back to main menu: ");
			
			String userInput = sc.next();
			if(context.getLoggedInUser()==null) {
				menuToNavigate = new MainMenu();
				System.out.println("You'r not logged in. Please, sign in or create an account.");
				break;
			}
			
			if(userInput.equalsIgnoreCase(MainMenu.MAIN_MENU_COMMAND)) {
				menuToNavigate = new MainMenu();
				break;
			}
			
			if(userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {
				Cart sessionCart = context.getSessionCart();
				if(sessionCart == null || sessionCart.isEmpty()) {
					System.out.println("Your cart is empty. Please add products to your cart to checkout.");
				}else {
					menuToNavigate = new CheckoutMenu();
					break;
				}
			}else {
				if(processCart(userInput)) {
					printMenuHeader();
				}else {
					System.out.print("Invalid Id:   ");
				}
			}
//			sc.close();
		}
		menuToNavigate.start();
	}
	
	private boolean processCart(String input) {
		int id = Integer.parseInt(input);
		Product product = productManagementService.getProductById(id);
		if(product==null) {
			return false;
		}else {
			Cart sessionCart = context.getSessionCart();
			sessionCart.addProduct(product);
			System.out.printf("PRODUCT: "+product+" has been added to your cart.");
			return true;
		}
	}
	
	@Override
	public void printMenuHeader() {
		System.out.println("**********PRODUCT CATALOG****************");
		for(Product product : productManagementService.getProducts()) {
			System.out.println(product);
		}
	}

}
