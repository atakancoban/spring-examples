package com.atakancoban.config;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.atakancoban.model.User;
import com.atakancoban.repository.UserRepository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDbConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
        	HashMap<String, String> map = new HashMap<>();
    		map.put("position", "Middle");
        	
        	userRepository.save(new User("1","Luis","Gustavo",map));
        	
        	HashMap<String, String> map1 = new HashMap<>();
    		map1.put("position", "Forward");
        	
        	userRepository.save(new User("2","Dimitris","Pelkas",map1));
        };
    }
}