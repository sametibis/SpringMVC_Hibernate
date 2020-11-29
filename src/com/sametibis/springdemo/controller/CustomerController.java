package com.sametibis.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sametibis.springdemo.entity.Customer;
import com.sametibis.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> theCustomers = customerService.getCustomers();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int theId, Model theModel) {
		
		// get customer from DB
		Customer theCustomer = customerService.getCustomer(theId);
		
		// pre-populated form -> set customer as a model attribute
		theModel.addAttribute("customer", theCustomer);
		
		// send to form with modelAttribute
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
}
