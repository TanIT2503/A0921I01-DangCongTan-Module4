package com.codegym.customer_managerment.controller;

import com.codegym.customer_managerment.entity.Customer;
import com.codegym.customer_managerment.entity.Province;
import com.codegym.customer_managerment.service.CustomerService;
import com.codegym.customer_managerment.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@Autowired
	ProvinceService provinceService;

	@GetMapping("create")
	public String create(Model model){
		Customer customers = new Customer();
		customers.setProvince(new Province());
		model.addAttribute("customers", customers);
		model.addAttribute("provinces", provinceService.getList());
		return "customer/create";
	}
	@PostMapping("create")
	public String create(@ModelAttribute("customers") Customer customers, Model model){
		customerService.create(customers);
		return "redirect:/customer/list";
	}

	@GetMapping("list")
	public String showListCustomer(@RequestParam(name = "nameCustomer", required = false) String name, Model model) {
		if (name != null && !name.isEmpty()) {
			model.addAttribute("customers", customerService.findByName(name));
		} else {
			model.addAttribute("customers", customerService.getList());
		}
		return "customer/list";
	}

	@GetMapping("{id}/edit/")
	public String showUpdate(@PathVariable("id") int id, Model model) {
		Customer customers = new Customer();
		customers.setProvince(new Province());
		model.addAttribute("province", provinceService.getList());
		model.addAttribute("customers", customerService.findById(id));
		return "/customer/edit";
	}
	@PostMapping("/customer/edit")
	public String update(Customer customer){
		customerService.update(customer);
		return "redirect:/customer/list";
	}
}
