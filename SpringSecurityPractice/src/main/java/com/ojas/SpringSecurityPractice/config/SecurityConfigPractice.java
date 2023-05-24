package com.ojas.SpringSecurityPractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigPractice {
	//Authentication
	@Bean
	public UserDetailsService schoolServiceDetails(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("Viswanadh")
				.password(encoder.encode("1234")).roles("ADMIN").build();
		
		UserDetails user = User.withUsername("Chinnam")
				.password(encoder.encode("456")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	//Authorization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/school/testmsg")
				.authenticated().and().formLogin().and().authorizeHttpRequests().requestMatchers("/school/testmsgauthorised")
		.authenticated().and().formLogin().and().build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
