package com.bookrental.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookrental.exception.NotFoundException;
import com.bookrental.models.Role;
import com.bookrental.models.User;
import com.bookrental.repository.RoleRepository;
import com.bookrental.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public void deleteUser(Long id) {
		User deletedUser = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
		
		userRepository.delete(deletedUser);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
	}
	
	public Role getUserRole(Integer id) {
		return roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
	}

}
