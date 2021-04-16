package com.atakancoban.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private Long id;

	private String name;

	private String surname;

	List<String> addressList;

}
