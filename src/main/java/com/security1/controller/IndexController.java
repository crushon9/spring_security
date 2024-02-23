package com.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.security1.model.User;
import com.security1.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({ "", "/" })
	public String index() {
		// Mustache 기본폴더 src/main/resources
		return "index"; // src/main/resources/templates/index.mustache -> WebMvcConfig를 통해 html로 설정
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "manager";
	}
	
	// 스프링 시큐리티가 낚아챔 -> SecurityConfig 설정으로 낚아채지않음
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(User user) {
		return userService.login(user);
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping("/join")
	public String join(User user) {
		return userService.join(user);
	}

}
