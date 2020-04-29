package com.psl.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.psl.aopdemo.Account;

@Component
public class AccountDAO {
	private int id;
	private String name;
	
	
	
	public int getId() {
		System.out.println("getter of id");
		return id;
	}



	public void setId(int id) {
		System.out.println("setter of id");
		this.id = id;
	}



	public String getName() {
		System.out.println("getter of name");
		return name;
	}



	public void setName(String name) {
		System.out.println("setter of name");
		this.name = name;
	}



	public void addAccount(Account account, Boolean x) {
		System.out.println(getClass()+" adding account to the database");
	}

}
