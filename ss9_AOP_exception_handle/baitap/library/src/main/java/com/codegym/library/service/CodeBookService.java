package com.codegym.library.service;

import com.codegym.library.entity.CodeBook;
import com.codegym.library.entity.Library;
import org.aspectj.apache.bcel.classfile.Code;

import java.util.List;

public interface CodeBookService {
    List<CodeBook> findAll();
    CodeBook findById(Integer id);

    void save(CodeBook codeBook);

    void delete(Integer id);

    List<CodeBook> findAllCodeByBookId(Integer id);

    List<CodeBook> findAvailableCodeBookByLibraryId(Integer id);

    List<CodeBook> findUsedCodeBookByLibraryId(Integer id);

    void returnBookByCode(Library library, Integer returnCode);
}
