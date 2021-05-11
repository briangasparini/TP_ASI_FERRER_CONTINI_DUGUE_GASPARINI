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
		Card createdCard=cRepository.save(h);
		System.out.println(createdCard);
	}
	
	public Card getCard(int id) {
		Optional<Card> hOpt =cRepository.findById(id);
		if (hOpt.isPresent()) {
			return hOpt.get();
		}else {
			return null;
		}
	}

	/*
	public void addCard(Card h) {
		System.out.println(h);
	}

	public Card getCard(int id) {
		Card h = new Card(1, "Pikachu", Family.ETOILES3, Affinity.ELECTRIC, 50, 80, 60, 20);
		return h;
	}
	*/

}
