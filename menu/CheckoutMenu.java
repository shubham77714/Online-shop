package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;
import oops.exercises.online_shop.entities.Order;
import oops.exercises.online_shop.services.OrderManagementService;

public class CheckoutMenu implements Menu {
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = OrderManagementService.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		while(true) {
			Scanner sc = new Scanner(System.in);
			String cardNumber = sc.next();
			Order order = new Order();
			if(order.isCreditCardNumberValid(cardNumber)) {
				order.setCreditCardNumber(cardNumber);
				order.setProducts(context.getSessionCart().getProducts());
				order.setCustomerId(context.getLoggedInUser().getId());
				orderManagementService.addOrder(order);
				System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
				break;
			}else {
				System.out.print("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.  : ");
			}
//			sc.close();
		}
		context.getSessionCart().clear();
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***********CHECKOUT MENU**************");
		System.out.print("Enter your credit card number without spaces and press enter if you confirm purchase: ");
	}

}
