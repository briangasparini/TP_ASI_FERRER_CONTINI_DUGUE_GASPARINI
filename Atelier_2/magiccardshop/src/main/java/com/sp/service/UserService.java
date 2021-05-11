package com.sp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository uRepository;

	@Autowired
	CardRepository cRepository;
	
	public void addUser(User h) {
		uRepository.save(h);
	}
	
	public Optional<User> connectUser(String login, String password) {
		Optional<User> u = uRepository.findByLogin(login);
		if (u != null) {
			u.get().setConnected(true);
			return u;
		} else {
			return null;
		}
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public Boolean sellCard(User user, Card card) {
		
		User admin = getUser(Integer.valueOf(0));
		
		// On crédite le vendeur
		user.setWallet(user.getWallet() + card.getPrix());
		
		// On soustrait l'admin 
		admin.setWallet(admin.getWallet() - card.getPrix());
		
		// On définit l'admin comme nouveau propriétaire
		card.setOwner(admin);
		
		return true;
	}

	public boolean cardPaiement(User user, Card card) {
		
		// Si l'user a assez de fonds
		if(user.getWallet() > card.getPrix()) {
			
			// On soustrait son solde
			user.setWallet(user.getWallet() - card.getPrix());
			
			// On le définit comme nouveau owner
			card.setOwner(user);
			
			return true;
		}		
		return false;
	}

	
	public List<Card> getCards(int userId){
		return cRepository.findUserCards(userId);
	}
}
