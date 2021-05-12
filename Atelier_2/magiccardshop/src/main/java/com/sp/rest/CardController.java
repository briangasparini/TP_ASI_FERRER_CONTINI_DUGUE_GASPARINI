package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.dto.CardDTO;
import com.sp.service.CardService;

@RestController
public class CardController {

	@Autowired
	CardService cService;

	@RequestMapping(method = RequestMethod.POST, value = "/cards")
	public void addCard(@RequestBody CardDTO Card) {
		cService.addCard(Card);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cards/{id}")
	public CardDTO getCard(@PathVariable String id) {
		return cService.getCard(Integer.valueOf(id));
	}

}
