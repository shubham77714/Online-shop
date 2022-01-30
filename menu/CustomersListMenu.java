package oops.exercises.online_shop.menu;

import oops.exercises.online_shop.entities.User;
import oops.exercises.online_shop.services.UserManagementService;

public class CustomersListMenu implements Menu {
	private UserManagementService userManagementService;
	{
		userManagementService = UserManagementService.getInstance();
	}
	@Override
	public void start() {
		printMenuHeader();
		User users[] = userManagementService.getUsers();
		if(users==null|| users.length==0) {
			System.out.println("Unfortunately, there is no customers.");
		}
		else {
			for(User user: users) {
				System.out.println(user);
			}
		}
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("************CUSTOMERS LIST**************");
	}

}
