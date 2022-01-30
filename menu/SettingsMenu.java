package oops.exercises.online_shop.menu;

import java.util.Scanner;

import oops.exercises.online_shop.configs.ApplicationContext;

public class SettingsMenu implements Menu {
	private static final String SETTINGS_MENU = "1. Change password\n 2. Change Email";
	private static final String SETTINGS_LOGGED_IN_ERROR = "Please, log in or create new account to change your account settings";
	private static final String SETTINGS_OPTION_ERROR = "Only 1, 2 is allowed. Try one more time";
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		Menu menuToNavigate = null; 
		if(context.getLoggedInUser()==null) {
			menuToNavigate = new MainMenu();
			System.out.println(SETTINGS_LOGGED_IN_ERROR);
		}else {
			settingLoop:while(true) {
				printMenuHeader();
				Scanner sc = new Scanner(System.in);
				System.out.print("User Input: ");
				String userInput = sc.next();
				if(userInput.equalsIgnoreCase(MainMenu.MAIN_MENU_COMMAND)){
					menuToNavigate = new MainMenu();
					break settingLoop;
				}else {
					int input = Integer.parseInt(userInput);
					switch(input) {
					case 1:
						menuToNavigate = new ChangePasswordMenu();
						break settingLoop;
					case 2:
						menuToNavigate = new ChangeEmailMenu();
						break settingLoop;
					default:
						System.out.println(SETTINGS_OPTION_ERROR);
						continue settingLoop;
					}
				}
//				sc.close();
			}
		}
		menuToNavigate.start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**********SETTINGS*************");
		System.out.println(SETTINGS_MENU);
	}

}
