package com.khan.etapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login","/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication()
//	.withUser("imran").password("imran").authorities("admin")
//	.and()
//	.withUser("james").password("imran").authorities("user")
//	.and()
//	.passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

		UserDetails user1 = User.withUsername("imran").password("imran").authorities("admin").build();

		UserDetails user2 = User.withUsername("james").password("james").authorities("user").build();

		userDetailsManager.createUser(user1);

		userDetailsManager.createUser(user2);

		auth.userDetailsService(userDetailsManager);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


}
