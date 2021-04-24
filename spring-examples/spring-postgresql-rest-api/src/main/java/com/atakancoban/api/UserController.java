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

import com.atakancoban.model.dto.UserDto;
import com.atakancoban.service.UserService;



@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public ResponseEntity<UserDto> addUser( @RequestBody UserDto userDto ) {    	
		return ResponseEntity.ok(userService.save(userDto));
	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDto>> getUserList() {

		return ResponseEntity.ok(userService.getAll());
	}

	@GetMapping("/")
	public String index() {
		return "Merhaba ben Atakan Coban.";
	}
	

}
