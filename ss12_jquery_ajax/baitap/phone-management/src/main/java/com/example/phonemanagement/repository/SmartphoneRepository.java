package com.example.phonemanagement.repository;

import com.example.phonemanagement.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    @Query (value = "select * from smartphone where id = :id", nativeQuery = true)
    public Smartphone findByID(@Param("id") Long id);
}
