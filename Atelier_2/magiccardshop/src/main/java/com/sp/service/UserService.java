package com.sp.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;
import com.sp.rest.AuthController;

@Service
public class UserService {

	@Autowired
	UserRepository uRepository;

	@Autowired
	CardRepository cRepository;
	
	public void addUser(User h) {
		uRepository.save(h);
	}
	
	public String connectUser(String login, String hashedPassword) {
		Optional<User> u = uRepository.findByLoginAndPassword(login, hashedPassword);
		if (u != null) {
			return Base64.getEncoder().encodeToString((login + "/" + hashedPassword + "/" + u.get().getId()).getBytes());
		} else {
			return null;
		}
	}
	
	public String disconnectUser() {
		return null;
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public List<Card> getCards(int userId){
		return cRepository.findUserCards(userId);
	}
}
