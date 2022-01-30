package oops.exercises.online_shop.menu;

import oops.exercises.online_shop.configs.ApplicationContext;
import oops.exercises.online_shop.entities.Order;
import oops.exercises.online_shop.services.OrderManagementService;

public class MyOrdersMenu implements Menu {
	private ApplicationContext context;
	private OrderManagementService orderMAnagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderMAnagementService = OrderManagementService.getInstance();
	}
	@Override
	public void start() {
		printMenuHeader();
		if(context.getLoggedInUser()==null) {
			System.out.println("Please, log in or create new account to see list of your orders");
		}
		else if(isEmptyOrdersList()) {
			System.out.println("Unfortunately, you don’t have any orders yet");
		}
		else {
			for(Order order: orderMAnagementService.getOrderByUserId(context.getLoggedInUser().getId())) {
				System.out.println(order);
			}
		}
		
		new MainMenu().start();
	}
	
	private boolean isEmptyOrdersList() {
		if(orderMAnagementService.getOrderByUserId(context.getLoggedInUser().getId())==null ||
				orderMAnagementService.getOrderByUserId(context.getLoggedInUser().getId()).length==0) {
			return true;
		}
		return false;
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**************MY ORDERS**************");
	}

}
