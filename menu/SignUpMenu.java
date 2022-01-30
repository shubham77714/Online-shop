package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;
import oops.exercises.online_shop.entities.User;
import oops.exercises.online_shop.services.UserManagementService;

public class SignUpMenu implements Menu {
	private UserManagementService userManagementServices;
	private ApplicationContext context;
	
	{
		userManagementServices= UserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		printMenuHeader();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your first name: ");
		String firstName = sc.next();
		System.out.print("Enter your last name: ");
		String lastName = sc.next();
		System.out.print("Enter your Email: ");
		String email = sc.next();
		System.out.print("Enter your password: ");
		String password = sc.next();
//		sc.close();
		
		User user= new User(firstName,lastName,password,email);
		
		String errorMessage = userManagementServices.registerUser(user);
		if(errorMessage==null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
			System.out.println("New user is created");
		}
		else {
			System.out.println(errorMessage);
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("********SIGN UP************");
	}

}
