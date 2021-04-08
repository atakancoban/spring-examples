package com.atakancoban.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakancoban.model.User;
import com.atakancoban.repository.UserRepository;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add")
	public ResponseEntity<User> addUser( @RequestBody User user ) {    	
		return ResponseEntity.ok(userRepository.save(user));
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> getUserList() {

		return ResponseEntity.ok(userRepository.findAll());
	}

	@GetMapping("/")
	public String index() {
		return "Merhaba ben Atakan Coban.";
	}

}
