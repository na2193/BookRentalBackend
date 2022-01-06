package com.bookrental.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookrental.models.User;
import com.bookrental.security.services.UserDetailsServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserDetailsServiceImpl userService;
	
	public UserController(UserDetailsServiceImpl userService) {
		this.userService= userService;
	}
	
	@GetMapping("/allUsers")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@GetMapping("/getUserRole/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<Role> getUserRole(@PathVariable("id") Integer id) {
//		Role role = userService.getUserRole(id);
//		return new ResponseEntity<>(role, HttpStatus.OK);
//	}
	
//	@GetMapping("/getUserRole/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public ResponseEntity<String> getUserRole(@PathVariable("id") Integer id) {
//		String role = userService.getUserRole(id).getRoleName();
//		System.out.println(role);
//		return new ResponseEntity<>(role, HttpStatus.OK);
//	}

}
