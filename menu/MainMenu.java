package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.MainDemo;
import oops.exercises.online_shop.configs.ApplicationContext;

public class MainMenu implements Menu {
	public static final String MAIN_MENU_COMMAND = "menu";
	
	private static final String MAIN_MENU_LOGGED_OUT_USER="1. Sign Up"+"\n2. Sign In"+"\n3. Product Catalog"+
						"\n4. My Orders"+"\n5. Settings"+"\n6. Customer List";
	private static final String MAIN_MENU_LOGGED_IN_USER="1. Sign Up"+"\n2. Sign Out"+"\n3. Product Catalog"+
			"\n4. My Orders"+"\n5. Settings"+"\n6. Customer List";
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		if(context.getMainMenu()==null) {
			context.setMainMenu(this);
		}
		
		Menu menuToNavigate = null;
		mainloop: while(true) {
					printMenuHeader();
					
					Scanner sc= new Scanner(System.in);
					System.out.print("User Input: ");
					String userInput=sc.next();
					if(userInput.equalsIgnoreCase(MainDemo.EXIT_COMMAND))
						System.exit(0);
					else {
						int commandNumber = Integer.parseInt(userInput);
						switch(commandNumber) {
						
						case 1:
							menuToNavigate= new SignUpMenu();
							break mainloop;
						case 2:
							if(context.getLoggedInUser()==null) {
								menuToNavigate = new SignInMenu();
							}
							else {
								menuToNavigate = new SignOutMenu();
							}
							break mainloop;
						case 3:
							menuToNavigate = new ProductCatalogMenu();
							break mainloop;
						case 4:
							menuToNavigate = new MyOrdersMenu();
							break mainloop;
						case 5:
							menuToNavigate = new SettingsMenu();
							break mainloop;
						case 6:
							menuToNavigate = new CustomersListMenu();
							break mainloop;
						default:
							System.out.println("Only 1,2,3,4,5,6 are allowed. Please, try again.");
							continue;
						}
					}
//					sc.close();
				}
		menuToNavigate.start();
	}
	
	@Override
	public void printMenuHeader() {
		System.out.println("**********MAIN MENU***********");
		if(context.getLoggedInUser()==null)
			System.out.println(MAIN_MENU_LOGGED_OUT_USER);
		else
			System.out.println(MAIN_MENU_LOGGED_IN_USER);
	}
	
}
