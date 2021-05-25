package com.sp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="USR_USER_ID", unique=true, nullable=false)
	private int id;
	private String name;
	private int wallet;
	private String login;
	private String password;
	
	@OneToMany
	private List<Card> listCard;
		
	public User() {
		
	}
	
	public User(int id, String name, int wallet, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.wallet = wallet;
		this.login = login;
		this.password = password;
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
	
	public int getWallet() {
		return wallet;
	}
	
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Card> getListCard() {
		return listCard;
	}

	public void setListCard(List<Card> listCard) {
		this.listCard = listCard;
	}
}
