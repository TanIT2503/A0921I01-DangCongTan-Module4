package com.codegym.blog_app.repository;

import com.codegym.blog_app.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
	@Query(value = "select * from Blog", nativeQuery = true)
	Page<Blog> findAllByNativeQuery1(Pageable pageable);

	@Query(value = "SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ",
			nativeQuery = true,
			countQuery = "select count(*) from ( SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ) abc ")
	Page<Blog> findAllByNativeQuery(@Param("author") String author, @Param("category") String category, Pageable pageable);
}
