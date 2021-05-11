package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class MarketService {

	@Autowired
	UserRepository uRepository;

	@Autowired
	CardRepository cRepository;
	
	@Autowired
	UserService uService;
	
	
	public Boolean sellCard(User user, Card card) {
		
		User admin = uService.getUser(Integer.valueOf(0));
		
		// On crédite le vendeur
		user.setWallet(user.getWallet() + card.getPrix());
		
		// On soustrait l'admin 
		admin.setWallet(admin.getWallet() - card.getPrix());
		
		// On définit l'admin comme nouveau propriétaire
		card.setOwner(admin);
		
		return true;
	}

	public boolean buyCard(User user, Card card) {
		
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

}
