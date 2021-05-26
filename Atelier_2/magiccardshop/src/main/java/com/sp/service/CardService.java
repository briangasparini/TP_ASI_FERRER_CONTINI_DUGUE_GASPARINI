package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.CardMapper;
import com.sp.model.dto.CardDTO;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	CardRepository cRepository;

	CardMapper cMapper = new CardMapper();

	public void addCard(CardDTO card) {
		cRepository.save(cMapper.convertCard(card));
	}

	public CardDTO getCard(int id) {
		Optional<CardDTO> hOpt = cRepository.findById(id).map(card -> cMapper.convertCardDto(card));
		if (hOpt.isPresent()) {
			return hOpt.get();
		} else {
			return null;
		}
	}

}
