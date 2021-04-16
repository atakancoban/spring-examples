package com.atakancoban.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atakancoban.model.dto.AddressDto;
import com.atakancoban.model.dto.UserDto;
import com.atakancoban.model.entity.Address;
import com.atakancoban.model.entity.User;
import com.atakancoban.repository.AddressRepository;
import com.atakancoban.repository.UserRepository;
import com.sun.nio.sctp.PeerAddressChangeNotification.AddressChangeEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public UserDto save(UserDto userDto) {
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

		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public UserDto getAll(UserDto userDto) {
		return null;
	}

	@Override
	public Page<UserDto> getAll(Pageable pageable) {
		return null;
	}

}
