package com.atakancoban.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atakancoban.model.dto.UserDto;

public interface UserService {

	UserDto save(UserDto userDto);
	
	void delete(Long id);
	
	UserDto getAll(UserDto userDto);
	
	Page<UserDto> getAll(Pageable pageable);
	
}
