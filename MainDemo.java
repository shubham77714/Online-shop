package oops.exercises.online_shop;

import oops.exercises.online_shop.menu.MainMenu;
import oops.exercises.online_shop.menu.Menu;

public class MainDemo {
	public static final String EXIT_COMMAND = "EXIT";
	
	public static void main(String[] args) {
		Menu menu = new MainMenu();
		menu.start();
	}

}
