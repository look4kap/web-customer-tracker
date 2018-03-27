package com.westchester.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.westchester.springdemo.entity.Customer;
import com.westchester.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		//1. get the list from DB
		List<Customer> customers = customerService.getCustomers();
		
		//2. add the list to the spring mvc model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	
	@RequestMapping("/showFormAddCustomer")
	public String showFormAddCustomer(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	@RequestMapping("/saveCustomer")
	public String saveCoustomer(@ModelAttribute("customer") Customer customer) {
		
		//save te customer using service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/showFormEditCustomer")
	public String showFormEditCustomer(@RequestParam("customerId") int theId , Model model) {
		
		//get the customer from service
		Customer customer = customerService.getCustomer(theId);

		//set the customer as a model attribute to pre-populate
		model.addAttribute("customer", customer);
		
		//send the form to view
		return "customer-form";
		
	}
}
