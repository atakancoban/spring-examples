package com.atakancoban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableReactiveMongoRepositories Mongo kullanılacagı icin ayaga kaldırılmalı.
@SpringBootApplication
public class SpringMongoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoRestApiApplication.class, args);
	}

}
