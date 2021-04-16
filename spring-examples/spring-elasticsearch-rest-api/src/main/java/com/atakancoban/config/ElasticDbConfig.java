package com.atakancoban.config;

import java.util.Calendar;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.atakancoban.model.User;
import com.atakancoban.repository.UserRepository;

@EnableElasticsearchRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class ElasticDbConfig {

	// load dummy data
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> {
			
			User user1 = new User();
			user1.setId("KOD001");
			user1.setName("Luis");
			user1.setSurname("Gustavo");
			user1.setAddress("Brasil  no 1");
			user1.setBirthday(Calendar.getInstance().getTime());
			
			User user2 = new User();
			user2.setId("KOD002");
			user2.setName("Dimitris");
			user2.setSurname("Pelkas");
			user2.setAddress("Greece  no 2");
			user2.setBirthday(Calendar.getInstance().getTime());
			
			User user3 = new User();
			user3.setId("KOD003");
			user3.setName("Ozan");
			user3.setSurname("Tufan");
			user3.setAddress("Turkey  no 3");
			user3.setBirthday(Calendar.getInstance().getTime());
			
			User user4 = new User();
			user4.setId("KOD004");
			user4.setName("Mesut");
			user4.setSurname("Özil");
			user4.setAddress("Turkey  zonguldak 1");
			user4.setBirthday(Calendar.getInstance().getTime());
			
			User user5 = new User();
			user5.setId("KOD005");
			user5.setName("Luis");
			user5.setSurname("Alberto");
			user5.setAddress("Mexico  no 1");
			user5.setBirthday(Calendar.getInstance().getTime());
			
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);
			userRepository.save(user5);
			
			
			
		};
	}
}