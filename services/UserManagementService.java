package oops.exercises.online_shop.services;

import java.util.Arrays;
import java.util.Objects;

import oops.exercises.online_shop.entities.User;

public class UserManagementService {
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USER_CAPACITY = 10;

	private static UserManagementService instance;

	private User[] users;
	private int lastUserIndex;

	{
		users = new User[DEFAULT_USER_CAPACITY];
	}

	public UserManagementService() {
	}

	public String registerUser(User user) {
		if (user == null) {
			return NO_ERROR_MESSAGE;
		}

		String errorMessage = checkUniqueEmail(user.getEmail());
		if (errorMessage != null && !errorMessage.isEmpty()) {
			return errorMessage;
		}

		if (users.length >= lastUserIndex) {
			users = Arrays.copyOf(users, lastUserIndex + DEFAULT_USER_CAPACITY);
		}
		users[lastUserIndex++] = user;
		return NO_ERROR_MESSAGE;
	}

	public String checkUniqueEmail(String email) {
		if (email == null || email.isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}

		for (User user : users) {
			if (user != null && user.getEmail() != null && email.equalsIgnoreCase(user.getEmail()))
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
		}
		return NO_ERROR_MESSAGE;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new UserManagementService();
		}
		return instance;
	}
	
	public User[] getUsers() {
		return Arrays.stream(users).filter(Objects::nonNull).toArray(User[]::new);
	}
	
	public User getUserByEmail(String email) {
		for(User user:users) {
			if(user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		return null;
	}
	
	void clearServiceState() {
		lastUserIndex=0;
		users=new User[DEFAULT_USER_CAPACITY];
	}
}
