package com.example.securingweb.presentacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/rest/**").permitAll()
				.antMatchers("/img/**", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		return new MiUserDetailsService();
//	}

	@Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
                        .userDetailsService(new MiUserDetailsService())
                        .passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		return new MiUserDetailsService();
//	}
}
