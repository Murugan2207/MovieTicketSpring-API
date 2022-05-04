package com.movieticketapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.movieticketapp.model.User;
import com.movieticketapp.repository.UserRepository;
import com.movieticketapp.validation.UserValidator;

@Service
public class UserService {

	@Autowired

	UserRepository userRepository;

	public void save(User user) throws Exception {

		try {
			UserValidator.validateRegister(user);
			userRepository.save(user);
			System.out.println("Successfully Registered");
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

	}

	public User login(User user) throws Exception {
		try {
			UserValidator.validateLogin(user);
			Optional<User> userLogin = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

			if (userLogin.isPresent()) {
				return userLogin.get();
			} else {
				throw new Exception("Invalid login credential");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
