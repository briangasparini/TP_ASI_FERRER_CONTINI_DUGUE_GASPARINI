package com.sp.model;

import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;

public class Card {

	private int id;
	private String name;
	private Family family;
	private Affinity affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	
	public Card() {
	}

	public Card(int id, String name, Family family, Affinity affinity, int hp, int energy, int attack, int defense) {
		super();
		this.id = id;
		this.name = name;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defense = defense;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Affinity getAffinity() {
		return affinity;
	}

	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	@Override
	public String toString() {
		return "Card ["+this.id+"]: name:"+this.name;
	}
}