package com.example.demo.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class WebConfig {

	private static final String[] WHITE_LIST_URLS = {};
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}
	
//	    public void configure(HttpSecurity http) throws Exception {
//	       http.csrf().disable().authorizeRequests()
//	        .antMatchers("/").permitAll()
//	        .antMatchers(HttpMethod.POST,"/register").permitAll()
////	        .antMatchers(HttpMethod.POST, "/login").permitAll()
////	        .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
////	        .antMatchers(HttpMethod.GET,"/master/*").permitAll()
////	         .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
//	        .anyRequest().authenticated();
//	    }
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.cors()
		.and()
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.antMatchers("*")
		.permitAll();
		return http.build();
	}
	
	 @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	       registry.addMapping("/**").allowedOrigins("*")
	                      .allowedMethods("PUT", "DELETE", "GET", "POST");
	      }
	    };
	 }
}
