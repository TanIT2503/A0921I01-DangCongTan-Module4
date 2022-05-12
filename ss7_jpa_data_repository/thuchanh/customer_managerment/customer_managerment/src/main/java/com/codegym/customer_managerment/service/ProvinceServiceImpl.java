package com.codegym.customer_managerment.service;

import com.codegym.customer_managerment.entity.Province;
import com.codegym.customer_managerment.repository.ProvinceRepository;
import com.codegym.customer_managerment.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Autowired
	private ProvinceRepository provinceRepository;
	@Override
	public List<Province> getList() {
		List<Province> provinces = new ArrayList<>();
		provinceRepository.findAll().forEach(p -> provinces.add(p));
		return provinces;
	}

	@Override
	public void create(Province province) {
		provinceRepository.save(province);
	}

	@Override
	public void update(Province province) {
		provinceRepository.save(province);
	}

	@Override
	public void delete(int id) {
		Province province = provinceRepository.findById(id).orElse(null);
		if (province != null) {
			provinceRepository.delete(province);
		}
	}
}
