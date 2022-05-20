package com.codegym.library.repository;

import com.codegym.library.entity.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeBookRepository extends JpaRepository<CodeBook, Integer> {
    List<CodeBook> findCodeBookByLibrary_Id(Integer id);
    List<CodeBook> findCodeBookByLibrary_IdAndStatus_Id(Integer bookId, Integer statusId);
}
