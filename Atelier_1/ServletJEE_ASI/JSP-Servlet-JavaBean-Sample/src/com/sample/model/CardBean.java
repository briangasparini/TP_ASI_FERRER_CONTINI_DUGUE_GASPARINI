package com.sample.model;

import java.io.Serializable;

public class CardBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String imgUrl;
	private Family family;
	private Affinity affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	
	public CardBean() {
		this.name = "";
		this.description = "";
		this.imgUrl = "";
		this.family = null;
		this.affinity = null;
		this.hp = 0;
		this.energy = 0;
		this.attack = 0;
		this.defense = 0;
	}
	
	public CardBean(String name, String description, String imgUrl, Family family, Affinity affinity, int hp,
			int energy, int attack, int defense) {
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defense = defense;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}
