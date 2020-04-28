package com.psl.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass()+" adding account to the database");
	}
	
	public boolean addMember() {
		System.out.println(getClass()+" adding member to the database");
		return true;
	}
	

}
