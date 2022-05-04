package com.movieticketapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketapp.model.User;
import com.movieticketapp.repository.UserRepository;
import com.movieticketapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@PostMapping("users/save") // register
	public ResponseEntity<String> save(@RequestBody User user) {
		try {

			userService.save(user);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("users/login")
	public ResponseEntity<String> login(@RequestBody User user) throws Exception {

		try {
			userService.login(user);
			return new ResponseEntity<String>("Success", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

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
	public void update(@PathVariable("user_id") Integer id, @RequestBody User user) {
		System.out.println("Successfully updated");
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
