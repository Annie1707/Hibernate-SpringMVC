package com.psl.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.psl.aopdemo.Account;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass()+" adding account to the database");
	}
	
	public boolean cutMember() {
		System.out.println(getClass()+" adding member to the database");
		return true;
	}
	

}
