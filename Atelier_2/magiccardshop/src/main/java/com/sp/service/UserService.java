package com.sp.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.CardMapper;
import com.sp.mapper.UserMapper;
import com.sp.model.User;
import com.sp.model.dto.CardDTO;
import com.sp.model.dto.UserDTO;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class UserService {

	public UserService() {
		this.uMapper = new UserMapper();
		this.cMapper = new CardMapper();
	}

	@Autowired
	UserRepository uRepository;

	@Autowired
	CardRepository cRepository;

	UserMapper uMapper;
	CardMapper cMapper;

	public void addUser(UserDTO h) {
		uRepository.save(UserMapper.convertUser(h));
	}

	public String connectUser(String login, String hashedPassword) {
		Optional<User> u = uRepository.findByLoginAndPassword(login, hashedPassword);
		if (u != null) {
			return Base64.getEncoder()
					.encodeToString((login + "/" + hashedPassword + "/" + u.get().getId()).getBytes());
		} else {
			return null;
		}
	}

	public String disconnectUser() {
		return null;
	}

	public UserDTO getUserDto(int id) {
		Optional<UserDTO> uOpt = uRepository.findById(id).map(user -> UserMapper.convertUserDto(user));
		if (uOpt.isPresent()) {
			return uOpt.get();
		} else {
			return null;
		}
	}

	public User getUserById(int id) {
		Optional<User> uOpt = uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		} else {
			return null;
		}
	}
	
	public UserDTO getUserByLogin(String login) {
		Optional<UserDTO> uOpt = uRepository.findByLogin(login).map(user -> UserMapper.convertUserDto(user));
		if (uOpt.isPresent()) {
			return uOpt.get();
		} else {
			return null;
		}
	}

	public List<CardDTO> getCards(int userId) {
		User user = uRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Error : Can't get cards linked to user : " + userId));
		return user.getListCard().stream().map(card -> cMapper.convertCardDto(card)).collect(Collectors.toList());
	}

}
