package com.atakancoban.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {


	
	@RequestMapping("/")
	public String index() {
		return "Merhaba ben Atakan Coban.";
	}

	
}