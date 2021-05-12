package com.sp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	private int id;
	private String name;
	private int wallet;
	private String login;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	public UserDTO() {
		
	}
	
	public UserDTO(int id, String name, int wallet, String login, String password) {
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
		
}
