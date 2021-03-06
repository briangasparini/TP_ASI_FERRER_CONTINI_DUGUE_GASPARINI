package com.sp.model.dto;

import com.sp.mapper.UserMapper;
import com.sp.model.User;
import com.sp.model.enumeration.Affinity;
import com.sp.model.enumeration.Family;

public class CardDTO {
	private int id;
	private String name;
	private String description;
	private Family family;
	private Affinity affinity;
	private String imgUrl;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	private int prix;
    private UserDTO owner;
    
    
    public CardDTO() {
    	
    }
    
    public CardDTO(int id, String name, String description, Family family, Affinity affinity, String imgUrl, int hp,
			int energy, int attack, int defense, int prix, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl = imgUrl;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defense = defense;
		this.prix = prix;
		this.owner = UserMapper.convertUserDto(owner);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public UserDTO getOwner() {
		return owner;
	}
	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}
}
