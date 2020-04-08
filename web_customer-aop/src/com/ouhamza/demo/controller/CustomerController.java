package com.ouhamza.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ouhamza.demo.dao.CustomerDAO;
import com.ouhamza.demo.entity.Customer;
import com.ouhamza.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String getList(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/showWindowForAdd")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/editCustomer")
	public String editCustomer(@RequestParam int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "customer-form";
	}	
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	
}
