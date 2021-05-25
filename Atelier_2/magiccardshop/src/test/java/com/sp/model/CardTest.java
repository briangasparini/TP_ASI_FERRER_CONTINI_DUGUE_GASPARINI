package com.sp.model;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;


public class CardTest {


	@Before
	public void setUp() {
		System.out.println("[CARD] - BEFORE -");
	}

	@After
	public void tearDown() {
		System.out.println("[CARD] - AFTER -");
	}

	@Test
	public void createCard() {
		
		int id = 0;
		int hp = 5;
		int energy = 100;
		int attack = 50;
		int defense = 25;
		int prix = 500;
		
		String name= "Pikachu";
		String description = "description";
		String imgUrl = "http://image.com";
		
		Family family = Family.ETOILE1;
		Affinity affinity = Affinity.BUG;
		
		User owner = new User(1, "John Doe", 50, "jde755", "M0t_D€_P@s$é");
		
		Card card = new Card(id, name, description, family, affinity, imgUrl, hp, energy, attack, defense, prix, owner);
		
		System.out.println(
				"id: "+id
				+", hp: "+hp
				+", energy: "+energy
				+", attack: "+attack
				+", defense: "+defense
				+", prix: "+prix
				+", name: "+name
				+", description: "+description
				+", imgUrl: "+imgUrl
				+", family"+family.toString()
				+", affinity: "+affinity.toString()
		);
		
		assertTrue(id == card.getId());
		assertTrue(hp == card.getHp());
		assertTrue(energy == card.getEnergy());
		assertTrue(attack == card.getAttack());
		assertTrue(defense == card.getDefense());
		assertTrue(prix == card.getPrix());
		assertTrue(name == card.getName());
		assertTrue(description == card.getDescription());
		assertTrue(imgUrl == card.getImgUrl());
		assertTrue(family == card.getFamily());
		assertTrue(affinity == card.getAffinity());
		
		
	}
	
	@Test
	public void displayCard() {
		
		int id = 0;
		int hp = 5;
		int energy = 100;
		int attack = 50;
		int defense = 25;
		int prix = 500;
		
		String name= "Pikachu";
		String description = "description";
		String imgUrl = "http://image.com";
		
		Family family = Family.ETOILE1;
		Affinity affinity = Affinity.BUG;
		
		User owner = new User(1, "John Doe", 50, "jde755", "M0t_D€_P@s$é");
		
		Card card = new Card(id, name, description, family, affinity, imgUrl, hp, energy, attack, defense, prix, owner);
		String expectedResult="Card [0]: name:Pikachu";
		
		assertTrue(expectedResult.equals(card.toString()));
		
	}

	
}
