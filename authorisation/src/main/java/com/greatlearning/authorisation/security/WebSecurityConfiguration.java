package com.greatlearning.authorisation.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.authorisation.service.UserDetailServiceImpl;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService getUserDetailService() {
		return new UserDetailServiceImpl();
		
	}
	
	@Bean
	public PasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider auth =new DaoAuthenticationProvider();
		auth.setUserDetailsService(getUserDetailService());
		auth.setPasswordEncoder(getBCryptPasswordEncoder());
		return auth;
	}

	@Override
	public void configure(AuthenticationManagerBuilder authBuilder) {
		authBuilder.authenticationProvider(getDaoAuthenticationProvider());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/student/","/student/showFormForAdd","/student/save").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/student/showFormForUpdate","/student/delete").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/student/")
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/student/403")
		.and()
		.cors().and().csrf().disable();
		}

}
