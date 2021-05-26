package com.sp.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.CardMapper;
import com.sp.mapper.UserMapper;
import com.sp.model.dto.CardDTO;
import com.sp.model.dto.UserDTO;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
@Transactional
public class MarketService {

	@Autowired
	UserRepository uRepository;

	@Autowired
	CardRepository cRepository;
	
	@Autowired
	UserService uService;
	
	UserMapper uMapper;
	CardMapper cMapper;
	
	@Transactional
	public Boolean sellCard(UserDTO user, CardDTO card) {
		
		UserDTO admin = UserMapper.convertUserDto(uService.getUserById(Integer.valueOf(0)));
		
		// On crédite le vendeur
		user.setWallet(user.getWallet() + card.getPrix());
		
		// On soustrait l'admin 
		admin.setWallet(admin.getWallet() - card.getPrix());
		
		// On définit l'admin comme nouveau propriétaire
		card.setOwner(admin);
		
		// Sauvegarde dans la BDD
		cRepository.saveNewOwner(UserMapper.convertUser(user), admin.getId());
		uRepository.saveNewBalance(user.getId(), user.getWallet());
		uRepository.saveNewBalance(admin.getId(), admin.getWallet());

		return true;
	}
	
	@Transactional
	public boolean buyCard(UserDTO user, CardDTO card) {
		
		UserDTO admin = UserMapper.convertUserDto(uService.getUserById(Integer.valueOf(0)));
		
		// Si l'user a assez de fonds
		if(user.getWallet() > card.getPrix()) {
			
			// On soustrait son solde
			user.setWallet(user.getWallet() - card.getPrix());
			
			// On le définit comme nouveau owner
			card.setOwner(user);
			
			// On crédite l'admin 
			admin.setWallet(admin.getWallet() + card.getPrix());
			
			// Sauvegarde dans la BDD
			cRepository.saveNewOwner(UserMapper.convertUser(user), card.getId());
			uRepository.saveNewBalance(user.getId(), user.getWallet());
			uRepository.saveNewBalance(admin.getId(), admin.getWallet());
			
			return true;
		}		
		return false;
	}

}
