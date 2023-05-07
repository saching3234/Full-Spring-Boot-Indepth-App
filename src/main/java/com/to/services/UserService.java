package com.to.services;

import java.util.List;

import com.to.dto.UserRequest;
import com.to.entity.Department;
import com.to.entity.User;
import com.to.error.DepartmentNotFoundException;
import com.to.error.UserNotFoundException;

public interface UserService {
	

		public User saveUser(UserRequest user);

		public List<User> fetchUserList();

		public User fetchUserId(int userId) throws UserNotFoundException;

		public User updateUser(int userId, UserRequest user);

		public Department fetchUserByName(String userName);

		public void deleteUserById(int userId) throws DepartmentNotFoundException;

	

}
