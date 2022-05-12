package com.codegym.customer_managerment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="province")
public class Province {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String province;
	@OneToMany(mappedBy = "province")
	List<Customer> customers;

	public Province() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
