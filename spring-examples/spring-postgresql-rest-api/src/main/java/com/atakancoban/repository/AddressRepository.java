package com.atakancoban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atakancoban.model.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
