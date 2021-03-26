package com.capelotto.auth.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capelotto.auth.config.SecurityConfig;
import com.capelotto.auth.entity.Permission;
import com.capelotto.auth.entity.User;
import com.capelotto.auth.jwt.JwtTokenProvider;
import com.capelotto.auth.message.sendMessage;
import com.capelotto.auth.repository.PermissionRepository;
import com.capelotto.auth.repository.UserRepository;


import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/user")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserRepository userRepository;
	
	@Autowired
	private SecurityConfig security;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private sendMessage sendMessage;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
			UserRepository userRepository) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userRepository = userRepository;
	}
	
	
	@RequestMapping("/testeSecurity")
	public String teste() {
		return "testado";
	}
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> create(@Valid @RequestBody User user){	
		var username = user.getUsername();
		User userExist = userRepository.findByUserName(username);
		if (userExist != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					"Usuario ja contem na base, por favor tente outro");
		}
		Permission permission = null;
		Permission findPermission = permissionRepository.findByDescription("Admin");
		if (findPermission == null) {
			permission = new Permission();
			permission.setDescription("Admin");
			permission = permissionRepository.save(permission);
		} else {
			permission = findPermission;
		}
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setPassword(security.passwordEncoder().encode(user.getPassword()));
		user.setPermissions(Arrays.asList(permission));
		userRepository.save(user);
		sendMessage.sendMessage(user);
		return ResponseEntity.ok(user);		
	}

	@PostMapping(path = "/login",produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> login(@RequestBody User userResult) {
		try {
			var username = userResult.getUsername();
			var password = userResult.getPassword();
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			var user = userRepository.findByUserName(username);
			
			var token = "";
			
			if(user != null) {
				token = "Bearer "+ jwtTokenProvider.createToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("User name not found");
			}
			
			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token",token);
			return ok(model);
			
		}catch(AuthenticationException e) {
			throw new BadCredentialsException("Ivalid username/password");
		}
	}
}
