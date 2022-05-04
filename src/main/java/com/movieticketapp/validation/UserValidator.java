package com.movieticketapp.validation;

import com.movieticketapp.model.User;

public class UserValidator {
	public static void validateRegister(User user) throws Exception {
		if (user.getName() == null || user.getName().trim() == "") {
			throw new Exception("Invalid Name");
		}

		if (user.getEmail() == null || user.getEmail().trim().equals("")) {
			throw new Exception("Invalid email");
		} else if (!user.getEmail().contains("@")) {
			throw new Exception("Email should contain @");
		}

		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			throw new Exception("Invalid password");
		} else if (user.getPassword().length() < 8) {
			throw new Exception("Password must be minimum 8 characters");
		}

		if (user.getPhoneNo() == null || user.getPhoneNo().trim().equals("")) {
			throw new Exception("Invalid PhoneNumber");
		} else if (user.getPhoneNo().length() != 10) {
			throw new Exception("PhoneNumber must be 10 digits only");
		}

	}
	public static void validateLogin(User userLogin) throws Exception {
		if (userLogin.getEmail() == null || userLogin.getEmail().trim().equals("")) {
			throw new Exception("Invalid email");
		} else if (!userLogin.getEmail().contains("@")) {
			throw new Exception("Email should contain @");
		}

		if (userLogin.getPassword() == null || userLogin.getPassword().trim().equals("")) {
			throw new Exception("Invalid password");
		} else if (userLogin.getPassword().length() < 8) {
			throw new Exception("Password must be minimum 8 characters");
		}
	}
}
