package com.codegym.customer_managerment.service;

import com.codegym.customer_managerment.entity.Customer;

import java.util.List;

public interface CustomerService {
	List<Customer> getList();
	void create(Customer customer);
	void update(Customer customer);
	void  delete(int id);
	List<Customer> findByName(String firstName);
	Customer findById(int id);
}
