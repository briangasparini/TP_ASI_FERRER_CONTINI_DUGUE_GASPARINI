package com.sp.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sp.model.Card;
import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;
import com.sp.service.CardService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardController.class)
public class CardControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CardService cardService;

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
	
	Card mockHero = new Card(id, name, description, family, affinity, imgUrl, hp, energy, attack, defense, prix);
	
	@Test
	public void retrieveCard() throws Exception {
		Mockito.when(
				cardService.getCard(Mockito.anyInt())
				).thenReturn(mockHero);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cards/50").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expectedResult="{\"id\":0,\"name\":\"Pikachu\",\"description\":\"description\",\"family\":ETOILE1,\"affinity\":\"BUG\",\"imgUrl\":\"http://image.com\",\"hp\":5,\"energy\":100,\"attack\":50,\"defense\":25,\"prix\":500}";


		JSONAssert.assertEquals(
			expectedResult,
			result.getResponse().getContentAsString(),
			false
		);
	}

	
}
