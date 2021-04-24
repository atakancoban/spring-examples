package com.atakancoban.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.atakancoban.model.dto.UserDto;
import com.atakancoban.model.entity.Address;
import com.atakancoban.model.entity.User;
import com.atakancoban.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;



	@Override
	@Transactional
	public UserDto save(UserDto userDto) {
		
		//Assert.isNull(userDto.getName(),"username cannot be empty !");
		
		User user = new User();
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());

		final User userDb = userRepository.save(user);
		
		List<Address>addresList = new ArrayList<Address>();
		
		userDto.getAddressList().forEach(item -> {

			Address address = new Address();

			address.setAddress(item);
			address.setAddressType(Address.AddressType.OTHER);
			address.setActive(true);
			address.setUser(userDb);
			
			addresList.add(address);

		});

		userDto.setId(userDb.getId());
		return userDto;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public Page<UserDto> getAll(Pageable pageable) {
		return null;
	}

	@Override
	public List<UserDto> getAll() {
		List<User> userlist = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		
		
		userlist.forEach(element -> {
			UserDto userDto = new UserDto();
			userDto.setId(element.getId());
			userDto.setName(element.getName());
			userDto.setSurname(element.getSurname());
			userDto.setAddressList(
					element.getAddressList().stream().map(Address::getAddress).collect(Collectors.toList()));
			userDtoList.add(userDto);
		});

		return userDtoList;
	}

}
