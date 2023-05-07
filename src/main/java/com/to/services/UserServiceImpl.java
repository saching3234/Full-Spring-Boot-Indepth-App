package com.to.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to.dto.UserRequest;
import com.to.entity.Department;
import com.to.entity.User;
import com.to.error.DepartmentNotFoundException;
import com.to.error.UserNotFoundException;
import com.to.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(UserRequest user) {
		// map all the value of the user request to the user object
		User user2 = User.builder().age(user.getAge()).email(user.getEmail()).gender(user.getGender())
				.mobile(user.getMobile()).name(user.getName()).nationality(user.getNationality()).build();

		return repository.save(user2);
	}

	@Override
	public List<User> fetchUserList() {

		return repository.findAll();
	}

	@Override
	public User fetchUserId(int userId) throws UserNotFoundException {
		Optional<User> user = repository.findById(userId);

		if (user.isPresent())
			return user.get();
		else
			throw new UserNotFoundException("No user record present for user id: " + userId);

	}

	@Override
	public User updateUser(int userId, UserRequest user) {

		return null;
	}

	@Override
	public Department fetchUserByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(int userId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub

	}

}
