package com.bionicuniversity.example_3_7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String login;
	private String passwordHex;
	private int role;
	private boolean del;
	
	public Account(String login, String passwordHex, int role) {
		super();
		this.login = login;
		this.passwordHex = passwordHex;
		this.role = role;
		this.del=false;
	}

	public Account(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPasswordHex() {
		return passwordHex;
	}
	
	public void setPasswordHex(String passwordHex) {
		this.passwordHex = passwordHex;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	public boolean isDel() {
		return del;
	}
	
	public void setDel(boolean del) {
		this.del = del;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", passwordHex="
				+ passwordHex + ", role=" + role + ", del="
				+ del + "]";
	}
	
}
