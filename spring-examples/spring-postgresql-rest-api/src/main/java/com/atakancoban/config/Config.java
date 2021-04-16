package com.atakancoban.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories
public class Config {

   /* @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
        	HashMap<String, String> map = new HashMap<>();
    		map.put("position", "Middle");
        	
        	userRepository.save(new User("1","Luis","Gustavo",map));
        	
        	HashMap<String, String> map1 = new HashMap<>();
    		map1.put("position", "Forward");
        	
        	userRepository.save(new User("2","Dimitris","Pelkas",map1));
        };
    }*/
}