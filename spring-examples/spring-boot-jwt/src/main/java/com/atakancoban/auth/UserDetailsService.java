package com.atakancoban.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	//DB yerine dummy map
	private Map<String, String> users = new HashMap<>();

	//parola şifreli saklanıyor
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//parolayı şifreli olarak dbdeymiş gibi ekle
	@PostConstruct
	public void init() {
		users.put("i2i", passwordEncoder.encode("123456"));
		users.put("atakan", passwordEncoder.encode("123456"));
		users.put("admin", passwordEncoder.encode("admin"));
	}

	//springin metodu,Username ve password bilgisi dolduruluyor
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if (users.containsKey(username)) {
			return new User(username, users.get(username), new ArrayList<>());
		}

		throw new UsernameNotFoundException(username);
	}
}
