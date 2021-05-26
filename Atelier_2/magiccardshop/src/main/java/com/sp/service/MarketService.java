package com.sp.service;

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
public class MarketService {

	@Autowired
	UserRepository uRepository;

	@Autowired
	CardRepository cRepository;
	
	@Autowired
	UserService uService;
	
	UserMapper uMapper;
	CardMapper cMapper;
	
	public Boolean sellCard(UserDTO user, CardDTO card) {
		
		UserDTO admin = uMapper.convertUserDto(uService.getUser(Integer.valueOf(0)));
		
		// On crédite le vendeur
		user.setWallet(user.getWallet() + card.getPrix());
		
		// On soustrait l'admin 
		admin.setWallet(admin.getWallet() - card.getPrix());
		
		// On définit l'admin comme nouveau propriétaire
		card.setOwner(admin);
		
		// Sauvegarde dans la BDD
		cRepository.saveNewOwner(card.getId(), admin.getId());
		uRepository.saveNewBalance(user.getId(), user.getWallet());
		uRepository.saveNewBalance(admin.getId(), admin.getWallet());

		return true;
	}

	public boolean buyCard(UserDTO user, CardDTO card) {
		
		UserDTO admin = uMapper.convertUserDto(uService.getUser(Integer.valueOf(0)));
		
		// Si l'user a assez de fonds
		if(user.getWallet() > card.getPrix()) {
			
			// On soustrait son solde
			user.setWallet(user.getWallet() - card.getPrix());
			
			// On le définit comme nouveau owner
			card.setOwner(user);
			
			// On crédite l'admin 
			admin.setWallet(admin.getWallet() + card.getPrix());
			
			// Sauvegarde dans la BDD
			cRepository.saveNewOwner(card.getId(), user.getId());
			uRepository.saveNewBalance(user.getId(), user.getWallet());
			uRepository.saveNewBalance(admin.getId(), admin.getWallet());
			
			return true;
		}		
		return false;
	}

}
