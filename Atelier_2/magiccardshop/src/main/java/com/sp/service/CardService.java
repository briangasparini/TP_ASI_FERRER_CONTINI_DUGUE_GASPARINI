package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.CardMapper;
import com.sp.model.Card;
import com.sp.model.dto.CardDTO;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	CardRepository cRepository;
	
	@Autowired
	UserService uService;

	public void addCard(CardDTO dto) {
		Card card = CardMapper.convertCard(dto);
		card.setOwner(uService.getUserById(Integer.valueOf(0)));
		cRepository.save(card);
	}

	public CardDTO getCard(int id) {
		Optional<CardDTO> hOpt = cRepository.findById(id).map(card -> CardMapper.convertCardDto(card));
		if (hOpt.isPresent()) {
			return hOpt.get();
		} else {
			return null;
		}
	}

}
