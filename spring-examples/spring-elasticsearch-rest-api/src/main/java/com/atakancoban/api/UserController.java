package com.atakancoban.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atakancoban.model.User;
import com.atakancoban.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	//@Autowired yerine @RequiredArgsConstructor lombok eklentisi ile inject edildi.
	private final UserRepository userRepository;
	
	@GetMapping("/{search}")
	public ResponseEntity<List<User>>  getUsers(@PathVariable String search)
	{
		List<User> userlist = userRepository.getByCustomerQuery(search);
		return ResponseEntity.ok(userlist);
	
	}
	
	@GetMapping("/like/{search}")
	public ResponseEntity<List<User>>  getLikeUser(@PathVariable String search)
	{
		List<User> userlist = userRepository.findByNameLikeOrSurnameLike(search,search);
		log.debug("deneme"+userlist.toString());
		return ResponseEntity.ok(userlist);
	
	}
	
	@GetMapping("/")
	public String index() {
		return "Merhaba ben Atakan Coban.";
	}
	
}
