package oops.exercises.online_shop.menu;


import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;
import oops.exercises.online_shop.entities.User;
import oops.exercises.online_shop.services.UserManagementService;

public class SignInMenu implements Menu {
	private UserManagementService userManagementService;
	private ApplicationContext context;
	
	{
		userManagementService = UserManagementService.getInstance();
		context= ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		printMenuHeader();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Email: ");
		String email= sc.nextLine();
		System.out.print("Enter your Password: ");
		String password = sc.next();
//		sc.close();
		
		User user = userManagementService.getUserByEmail(email);
		if(user!=null && user.getPassword().equals(password)) {
			System.out.printf("Glad to see you back %s %s",user.getFirstName(),user.getLastName());
			context.setLoggedInUser(user);
		}
		else {
			System.out.println("Unfortunately, Such login and password doesn't exist.");  
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***********SIGN IN*************");
	}

}
