package com.psl.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.psl.aopdemo.dao.AccountDAO;
import com.psl.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account account = new Account();
		dao.addAccount(account,true);
		dao.getId();
		dao.getName();
		dao.setId(1);
		dao.setName("anu");
//		System.out.println("running once again");
//		membershipDAO.cutMember();;
//		membershipDAO.addAccount();
		context.close();
	}
}
