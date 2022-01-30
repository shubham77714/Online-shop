package oops.exercises.online_shop.menu;

import oops.exercises.online_shop.configs.ApplicationContext;
public class SignOutMenu implements Menu {
	private ApplicationContext context;
	{
		context= ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		context.setLoggedInUser(null);
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***********SIGN OUT************");
		System.out.println("Have a nice day! look forward to welcoming back.");
	}

}
