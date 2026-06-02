package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/api/student/get/**")
						.hasAnyRole("student", "Admin").requestMatchers(HttpMethod.POST, "/api/student/create/**")
						.hasRole("Admin").requestMatchers(HttpMethod.PUT, "/api/student/update/**")
						.hasAnyRole("student", "Admin").requestMatchers(HttpMethod.DELETE, "/api/student/delete**")
						.hasRole("Admin").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()));

		return http.build();
	}

	@Bean
	UserDetailsService detailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.builder().username("a").password(passwordEncoder.encode("a")).roles("Admin").build();

		UserDetails student = User.builder().username("s").password(passwordEncoder.encode("s")).roles("student")
				.build();

		return new InMemoryUserDetailsManager(admin, student);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
