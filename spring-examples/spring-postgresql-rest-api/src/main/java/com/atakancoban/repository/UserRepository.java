package com.atakancoban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atakancoban.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
