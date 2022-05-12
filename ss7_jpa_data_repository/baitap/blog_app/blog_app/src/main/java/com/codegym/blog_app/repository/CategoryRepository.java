package com.codegym.blog_app.repository;

import com.codegym.blog_app.entity.Blog;
import com.codegym.blog_app.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
	@Query(value = "select * from Category", nativeQuery = true)
	List<Category> findAllByNativeQuery();
}
