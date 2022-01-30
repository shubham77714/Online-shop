package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;

public class ChangeEmailMenu implements Menu {
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		System.out.println("Enter new email: ");
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		context.getLoggedInUser().setEmail(email);
//		sc.close();
		System.out.println("Your Email has been changed successfully.");
		new MainMenu().start();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("**********SETTINGS: Change Email**************");
	}

}
