package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LoginCredentials;
import com.example.demo.repository.JwtRepo;
import com.example.demo.security.JWTUtil;
import com.example.demo.entity.UserJwt;
import com.example.demo.entity.Users;
import com.example.demo.model.LoginModel;
import com.example.demo.service.RegisterService;

@RestController
public class LoginController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private AuthenticationManager authenticationManger;

    @Autowired private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtRepo jwtRepo;
	
    @Autowired 
    private JWTUtil jwtUtil;
    
    @PostMapping("/registers")
    public Map<String, Object> registerHandler(@RequestBody UserJwt user){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = jwtRepo.save(user);
        String token = jwtUtil.generateToken(user.getEmail());
        return Collections.singletonMap("jwt-token", token);
    }
	
	@PostMapping(value="/login")
	 public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
		System.out.println(body);
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            authenticationManger.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getEmail());

            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }
//	public String LoginUser(@RequestBody Users loginModel) {
//		
//		System.out.println(loginModel.getEmail() + " " + loginModel.getPassword());
//		Users s = registerService.LoginUser(loginModel);
//		return s.getRole();
//		
//		try {
//		Authentication value = authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword(), Collections.emptyList()));
//		System.out.println("value " + value);
//		}
//		catch(Exception ex) {
//			System.out.println("Exception " + ex);
//		}
//		return "OK";
//	}
	
}
