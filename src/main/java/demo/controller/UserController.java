package demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.repo.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/user")
	public Map<String, Object> getUser(Authentication authentication) {
		Map<String, Object> model = new HashMap<String, Object>();

		String userName = authentication.getName();
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			String role = authority.getAuthority();
			msg += role + ";";
		}
		model.put("User Name", userName);
		model.put("Roles", "(" + msg + ")");
		return model;
	}
	@RequestMapping("/logout")
	public Map<String, Object> logout(Authentication authentication) {
		Map<String, Object> model = new HashMap<String, Object>();
		authentication.setAuthenticated(false);
		
		model.put("User Name", "");
		model.put("Roles", "()");
		return model;
	}
}
