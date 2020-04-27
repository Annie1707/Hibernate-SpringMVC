package com.psl.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psl.springdemo.dao.CustomerDAO;
import com.psl.springdemo.entity.Customer;
import com.psl.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> customers = service.getCustomers();
		
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = service.getCustomer(id);
		
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		service.deleteCustomer(id);
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/search")
	public String searchResult(@RequestParam("input") String input, Model model) {
		List<Customer> customers = service.searchCustomers(input);
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
