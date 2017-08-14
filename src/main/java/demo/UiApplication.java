package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class UiApplication {

	// @RequestMapping("/user")
	// public Principal user(Principal user) {
	// return user;
	// }
	//
	// @RequestMapping("/resource")
	// public Map<String, Object> home() {
	// Map<String, Object> model = new HashMap<String, Object>();
	// model.put("id", UUID.randomUUID().toString());
	// model.put("content", "Hello World");
	// return model;
	// }

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	// @Configuration
	// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	// protected static class SecurityConfiguration extends
	// WebSecurityConfigurerAdapter {
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// // @formatter:off
	// http.httpBasic().and().authorizeRequests().antMatchers("/index.html",
	// "/home.html", "/login.html", "/")
	// .permitAll().anyRequest().authenticated().and().csrf()
	// .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	// // @formatter:on
	// }
	//
	// @Override
	// public void configure(AuthenticationManagerBuilder auth) throws Exception
	// {
	// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN",
	// "USER").and()
	// .withUser("user").password("user").roles("USER");
	// }
	//
	// }

}
