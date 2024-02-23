package com.security1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.security1.model.User;
import com.security1.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String login(User user) {
		User inputUser = user;
		User getDBUser = userRepository.findByUserid(user.getUserid());
		if (bCryptPasswordEncoder.matches(inputUser.getPassword(), getDBUser.getPassword())) {
			return "redirect:/";
		} else {
			return "fail";
		}
	}
	
	public String join(User user) {
		user.setRole("ROLE_USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		return "redirect:/loginForm";
	}

}
