package com.sp.service;

import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;

@Service
public class CardService {
	 public void addCard(Card h) {
         System.out.println(h);
     }
     
     public Card getCard(int id) {
         Card h = new Card(1, "Pikachu", Family.ETOILES3, Affinity.ELECTRIC, 50, 80, 60, 20);
         return h;
     }

}
