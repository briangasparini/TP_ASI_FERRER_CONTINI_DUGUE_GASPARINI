package com.sp.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.mapper.CardMapper;
import com.sp.model.Card;
import com.sp.model.User;
import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;
import com.sp.repository.CardRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardService.class)
public class CardServiceTest {

	
	@Autowired
	private CardService cardServ;

	@MockBean
	private CardRepository cardRepo;
	
	private int id = 0;
	private int hp = 5;
	private int energy = 100;
	private int attack = 50;
	private int defense = 25;
	private int prix = 500;
	
	private String name= "Pikachu";
	private String description = "description";
	private String imgUrl = "http://image.com";
	
	private Family family = Family.ETOILE1;
	private Affinity affinity = Affinity.BUG;
	
	private User owner = new User(1, "John Doe", 50, "jde755", "M0t_D€_P@s$é");
	
	private Card tmpCard = new Card(id, name, description, family, affinity, imgUrl, hp, energy, attack, defense, prix, owner);
	
	@Test
	public void getCard() {
		Mockito.when(
			cardRepo.findById(Mockito.any())
		).thenReturn(Optional.ofNullable(tmpCard));
		
		CardMapper mapper = new CardMapper();
		Card cardInfo = mapper.convertCard(cardServ.getCard(45));
		
		assertTrue(cardInfo.toString().equals(tmpCard.toString()));
	}

	
}
