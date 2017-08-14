package demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.entity.Role;
//import demo.entity.User;
import demo.repo.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		demo.entity.User User = userRepository.findByUserName(username);
		List<Role> roles = User.getRoles();
		List<GrantedAuthority> grantedAuthoritys= new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
			grantedAuthoritys.add(authority);
		}
		
		UserDetails userDetails = (UserDetails)new User(User.getUserName(), 
				User.getPassword(), grantedAuthoritys);
		return userDetails;
	}
}
