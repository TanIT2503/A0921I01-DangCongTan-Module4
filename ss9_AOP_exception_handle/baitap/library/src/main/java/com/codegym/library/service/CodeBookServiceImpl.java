package com.codegym.library.service;

import com.codegym.library.entity.CodeBook;
import com.codegym.library.entity.Library;
import com.codegym.library.entity.Status;
import com.codegym.library.repository.CodeBookRepository;
import com.codegym.library.repository.LibraryRepository;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeBookServiceImpl implements CodeBookService{
    @Autowired
    CodeBookRepository codeBookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<CodeBook> findAll() {
        return null;
    }

    @Override
    public CodeBook findById(Integer id) {
        return null;
    }

    @Override
    public void save(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<CodeBook> findAllCodeByBookId(Integer id) {
        return codeBookRepository.findCodeBookByLibrary_Id(id);
    }

    @Override
    public List<CodeBook> findAvailableCodeBookByLibraryId(Integer id) {
        return codeBookRepository.findCodeBookByLibrary_IdAndStatus_Id(id, 1);
    }

    @Override
    public List<CodeBook> findUsedCodeBookByLibraryId(Integer id) {
        return codeBookRepository.findCodeBookByLibrary_IdAndStatus_Id(id, 2);
    }

    @Override
    public void returnBookByCode(Library library, Integer returnCode) {
        CodeBook codeBook=codeBookRepository.findById(returnCode).orElse(null);
        library =codeBook.getLibrary();
        library.returnBook();
        libraryRepository.save(library);
        codeBook.setStatus(new Status(1, "available"));
    }
}
