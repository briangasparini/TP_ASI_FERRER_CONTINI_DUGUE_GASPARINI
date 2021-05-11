package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;

@Entity
public class Card {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private Family family;
	private Affinity affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	private int prix;
	
	@ManyToOne
	@JoinColumn(name="USR_USER_ID")
    private User owner;
	
	public Card() {
	}

	public Card(int id, String name, String description, Family family, Affinity affinity, int hp, int energy, int attack, int defense, int prix) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Card ["+this.id+"]: name:"+this.name;
	}
}