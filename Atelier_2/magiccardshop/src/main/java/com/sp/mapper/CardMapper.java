package com.sp.mapper;

import com.sp.model.Card;

import com.sp.model.dto.CardDTO;

public class CardMapper {

	public CardDTO convertCardDto(Card card) {
		return new CardDTO(card.getId(), card.getName(), card.getDescription(), card.getFamily(), card.getAffinity(), card.getImgUrl(), card.getHp(), card.getEnergy(), card.getAttack(), card.getDefense(), card.getPrix(), card.getOwner());
	}

	public Card convertCard(CardDTO cardDto) {
		return new Card(cardDto.getId(), cardDto.getName(), cardDto.getDescription(), cardDto.getFamily(), cardDto.getAffinity(), cardDto.getImgUrl(), cardDto.getHp(), cardDto.getEnergy(), cardDto.getAttack(), cardDto.getDefense(), cardDto.getPrix(), UserMapper.convertUser(cardDto.getOwner()));
	}
}
