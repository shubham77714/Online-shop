package oops.exercises.online_shop.configs;

import oops.exercises.online_shop.entities.Cart;
import oops.exercises.online_shop.entities.User;
import oops.exercises.online_shop.menu.Menu;

public class ApplicationContext {
	private static ApplicationContext instance;
	
	private User loggedInUser;
	private Menu mainMenu;
	private Cart sessionCart;
	
	private ApplicationContext() {
		
	}
	
	public void setLoggedInUser(User user) {
		if(this.sessionCart!=null)
			this.sessionCart.clear();
		this.loggedInUser = user;
	}
	
	public User getLoggedInUser() {
		return this.loggedInUser;
	}
	
	public void setMainMenu(Menu menu) {
		this.mainMenu=menu;
	}
	
	public Menu getMainMenu() {
		return this.mainMenu;
	}
	
	public Cart getSessionCart() {
		if(sessionCart == null) {
			sessionCart = new Cart();
		}
		return sessionCart;
	}
	
	public static ApplicationContext getInstance() {
		if(instance==null) {
			instance = new ApplicationContext();
		}
		return instance;
	}
}
