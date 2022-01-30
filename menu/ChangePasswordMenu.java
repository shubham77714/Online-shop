package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;

public class ChangePasswordMenu implements Menu {
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		printMenuHeader();
		System.out.println("Enter new password: ");
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		context.getLoggedInUser().setPassword(password);
//		sc.close();
		System.out.println("Your password has been changed successfully.");
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("*********SETTINGS: Change Password*************");
	}

}
