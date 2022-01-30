package oops.exercises.online_shop.entities;

public class User {
	private static int userCounter =0;
	
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	{
		id = ++userCounter;
	}
	
	
	public User() {
	}
	
	public User(String firstName,String lastName,String password,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.email=email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	
	public String getLastName() {
		return this.lastName;
	}

	
	public String getPassword() {
		return this.password;
	}

	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() +
				"  Last Name: " + this.getLastName() +"\t" +
				"Email: " + this.getEmail();
	}

	
	public void setPassword(String password) {
		if (password == null) {
			return;
		}
		this.password = password;
	}

	
	public void setEmail(String newEmail) {
		if (newEmail == null) {
			return;
		}
		this.email = newEmail;
	}

	public int getId() {
		return this.id;
	}
	
	void clearState() {
		userCounter = 0;
	}
	
}
