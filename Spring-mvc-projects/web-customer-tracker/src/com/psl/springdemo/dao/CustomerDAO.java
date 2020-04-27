package com.psl.springdemo.dao;

import java.util.List;

import com.psl.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String input);
}
