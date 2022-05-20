package com.codegym.library.service;

import com.codegym.library.entity.CodeBook;
import com.codegym.library.entity.Library;
import com.codegym.library.exception.NotAvailableException;
import com.codegym.library.exception.WrongCodeException;

import java.util.List;

public interface LibraryService {
	List<Library> findAll();
	void save(Library library);
	void delete(Integer id);
	void borrow(Library library, Integer usedCode);
	void returnLibrary(Library library, Integer returnCode) throws NotAvailableException, WrongCodeException;
	Library findById(Integer id);
	CodeBook getNextAvailableCodeBook(Library library) throws NotAvailableException;

	void returnBook(Library library, Integer returnCode) throws NotAvailableException, WrongCodeException;
	public boolean checkNoUsedCode(Library library);
}
