package com.sample.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sample.model.Affinity;
import com.sample.model.CardBean;
import com.sample.model.Family;

public class CardDao {
	private List<CardBean> myCardList;
	
	public CardDao() {
		myCardList=new ArrayList<>();
		createCardList();
	}

	private void createCardList() {
		
		CardBean p1=new CardBean("Pikachu", "Pokémon jaune", "https://media3.giphy.com/media/U2nN0ridM4lXy/200.gif", Family.POKEMON, Affinity.FIRE, 100, 100, 100, 100);

		myCardList.add(p1);
	}
	
	
	public List<CardBean> getCardList() {
		return this.myCardList;
	}
	
	public void addCardToList(CardBean cardBean) {
		myCardList.add(cardBean);
	}
	
	public CardBean getCardByName(String name){
		for (CardBean cardBean : myCardList) {
			if(cardBean.getName().equals(name)){
				return cardBean;
			}
		}
		return null;
	}
	
}
