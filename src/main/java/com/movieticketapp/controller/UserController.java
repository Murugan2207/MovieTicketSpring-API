package com.movieticketapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketapp.model.User;
import com.movieticketapp.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("users/save") // register
	public User save(@RequestBody User user) {
		userRepository.save(user);
		return user;

	}

	@GetMapping("users/list")
	public List<User> findAll() {
		List<User> userlist = userRepository.findAll();
		return userlist;
	}

	@DeleteMapping("users/delete/{user_id}")
	public void delete(@PathVariable("user_id") Integer user_id) {
		userRepository.deleteById(user_id);

	}
	@PutMapping("users/update/{user_id}")
	public void update(@PathVariable("user_id")Integer id,@RequestBody User user) {
		System.out.println("Update called");
		user.setId(id);
		userRepository.save(user);
	}

	@GetMapping("users/find/{user_id}")
	public User findById(@PathVariable("user_id") Integer user_id) {
		Optional<User> user = userRepository.findById(user_id);
		if (user.isPresent()) {
			User userObj = user.get();
			return userObj;
		} else {
			return null;
		}

	}

}
