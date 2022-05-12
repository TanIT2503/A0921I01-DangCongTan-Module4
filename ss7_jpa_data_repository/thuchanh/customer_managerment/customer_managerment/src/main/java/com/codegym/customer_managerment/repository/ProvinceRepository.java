package com.codegym.customer_managerment.repository;

import com.codegym.customer_managerment.entity.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Integer> {
}
