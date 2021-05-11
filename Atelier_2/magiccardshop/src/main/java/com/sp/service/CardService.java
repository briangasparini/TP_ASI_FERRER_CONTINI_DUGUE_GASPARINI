package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cRepository;
	
	public void addCard(Card h) {
		cRepository.save(h);
	}
	
	public Card getCard(int id) {
		Optional<Card> hOpt =cRepository.findById(id);
		if (hOpt.isPresent()) {
			return hOpt.get();
		}else {
			return null;
		}
	}

}
