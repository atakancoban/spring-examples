package com.atakancoban.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atakancoban.model.User;


public interface UserRepository extends MongoRepository<User, String> {
	
 

}
