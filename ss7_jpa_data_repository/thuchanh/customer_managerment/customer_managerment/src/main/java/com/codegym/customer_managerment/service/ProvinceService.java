package com.codegym.customer_managerment.service;


import com.codegym.customer_managerment.entity.Province;

import java.util.List;

public interface ProvinceService {
	List<Province> getList();
	void create(Province province);
	void update(Province province);
	void  delete(int id);
}
