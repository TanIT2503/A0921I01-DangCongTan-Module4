package com.codegym.customer_managerment.service;

import com.codegym.customer_managerment.entity.Customer;
import com.codegym.customer_managerment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public List<Customer> getList() {
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(c -> customers.add(c));
		return customers;
	}

	@Override
	public void create(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void delete(int id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer != null) {
			customerRepository.delete(customer);
		}
	}

	@Override
	public List<Customer> findByName(String firstName) {
		return null;
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id).orElse(null);
	}
}
