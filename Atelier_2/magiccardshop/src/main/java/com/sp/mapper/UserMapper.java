package com.sp.mapper;

import com.sp.model.User;
import com.sp.model.dto.UserDTO;

public class UserMapper {

	public static UserDTO convertUserDto(User user) {
		return new UserDTO(user.getId(), user.getName(), user.getWallet(), user.getLogin(), user.getPassword());
	}
	
	public static User convertUser(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getWallet(), userDto.getLogin(), userDto.getPassword());
	}
}
