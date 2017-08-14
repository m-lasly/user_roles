package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import demo.entity.Role;
import demo.repo.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserRepository userRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				demo.entity.User account = userRepository.findByUserName(username);
				List<Role> roles = account.getRoles();
				List<GrantedAuthority> grantedAuthoritys = new ArrayList<GrantedAuthority>();
				for (Role role : roles) {
					GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
					grantedAuthoritys.add(authority);
				}

				if (account != null) {
					return new User(account.getUserName(), account.getPassword(), grantedAuthoritys);
				} else {
					throw new UsernameNotFoundException("could not find the user '" + username + "'");
				}
			}

		};
	}

}

// @Autowired
// Environment env;
//
// @Autowired
// AuthenticationService authenticationService;
//
// @Autowired
// private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//// @Override
//// protected void configure(HttpSecurity http) throws Exception {
//// http.authorizeRequests()
//// .antMatchers("/", "/auth/**").permitAll()
//// .antMatchers("/secured").hasRole("USER");
//// }
//
//// @Override
//// protected void configure(HttpSecurity http) throws Exception {
//// http.authorizeRequests()
//// .antMatchers("/index.html",
//// "/home.html", "/login.html", "/").permitAll()
//// .antMatchers("/info/**").hasAnyRole("ADMIN","USER").
//// and().formLogin();
//// }
//// @Autowired
//// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
//// ShaPasswordEncoder encoder = new ShaPasswordEncoder();
//// auth.userDetailsService(authenticationService).passwordEncoder(encoder);
//// }
//
//// @Autowired
//// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
//// ShaPasswordEncoder encoder = new ShaPasswordEncoder();
//// auth.userDetailsService(authenticationService).passwordEncoder(encoder);
//// }
////
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http
// .authorizeRequests()
// .antMatchers("/index.html",
// "/home.html", "/login.html", "/").permitAll()
// .anyRequest().authenticated()
// .and()
// .formLogin()
// .loginPage("/login")
// .permitAll()
// .and()
// .logout()
//// .permitAll();
// ;
// }
// @Autowired
// private DataSource dataSource;
//
// @Value("${spring.queries.users-query}")
// private String usersQuery;
//
// @Value("${spring.queries.roles-query}")
// private String rolesQuery;
// @Override
// protected void configure(AuthenticationManagerBuilder auth)
// throws Exception {
// auth.
// jdbcAuthentication()
// .usersByUsernameQuery(usersQuery)
// .authoritiesByUsernameQuery(rolesQuery)
// .dataSource(dataSource)
// .passwordEncoder(bCryptPasswordEncoder);
// }
//
//
//
//
// @Bean
// public JdbcUserDetailsManager userDetailsManager() {
// JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
// manager.setDataSource(dataSource);
// manager.setUsersByUsernameQuery(
// usersQuery);
// manager.setAuthoritiesByUsernameQuery(
// "rolesQuery");
// manager.setRolePrefix("ROLE_");
// return manager;
// }
//
// @Autowired
// public void configAuthentication(AuthenticationManagerBuilder builder)
// throws Exception {
//
// builder.userDetailsService(userDetailsManager());
// }
//
//// @Override
//// protected void configure(HttpSecurity http) throws Exception {
//// // @formatter:off
//// http.httpBasic().and().authorizeRequests().antMatchers("/index.html",
//// "/home.html", "/login.html", "/")
//// .permitAll();
//// // @formatter:on
//// }
//// anyRequest().authenticated().and().csrf()
//// .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//
//// protected void configure(HttpSecurity http) throws Exception {
//// http.authorizeRequests().antMatchers("/test/**").hasAnyRole("ADMIN",
// "USER").and().formLogin();
//// }
// // @Autowired
// // public void configureGlobal(AuthenticationManagerBuilder auth) throws
// // Exception {
// //
// auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
// // }
//
// // @Override
// // public void configure(AuthenticationManagerBuilder auth) throws Exception
// // {
// //
// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN",
// // "USER").and().withUser("user")
// // .password("user").roles("USER");
// // }

// }