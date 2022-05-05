package com.movieticketapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.movieticketapp.exception.ServiceException;
import com.movieticketapp.exception.ValidationException;
import com.movieticketapp.model.User;
import com.movieticketapp.repository.UserRepository;
import com.movieticketapp.validation.UserValidator;

@Service
public class UserService {

	@Autowired

	UserRepository userRepository;

	public void save(User user) throws ServiceException,ValidationException {

		try {
			UserValidator.validateRegister(user);
			userRepository.save(user);
			System.out.println("Successfully Registered");
		} catch (DataAccessException e) {

			e.printStackTrace();
			throw new ServiceException (e.getMessage());
		}

	}

	public User login(User user) throws Exception {
		try {
			UserValidator.validateLogin(user);
			Optional<User> userLogin = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

			if (userLogin.isPresent()) {
				return userLogin.get();
			} else {
				throw new ServiceException("Invalid login credential");
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException (e.getMessage());
			}

	}
}
