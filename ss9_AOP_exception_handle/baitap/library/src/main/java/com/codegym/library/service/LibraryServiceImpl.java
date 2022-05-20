package com.codegym.library.service;

import com.codegym.library.entity.CodeBook;
import com.codegym.library.entity.Status;
import com.codegym.library.exception.NotAvailableException;
import com.codegym.library.exception.WrongCodeException;
import com.codegym.library.repository.LibraryRepository;
import com.codegym.library.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	CodeBookService codeBookService;
	@Override
	public List<Library> findAll() {
		return libraryRepository.findAll();
	}

	@Override
	public void save(Library library) {
		libraryRepository.save(library);
		Status available = new Status(1);
		for(int i=0; i<library.getQuantity(); i++){
			int n =10000 + new Random().nextInt(90000);
			CodeBook codeBook = new CodeBook(n,libraryRepository.findById(library.getId()).orElse(null),available);
			library.generateCode(codeBook);
			codeBookService.save(codeBook);
		}
	}

	@Override
	public void delete(Integer id) {
		libraryRepository.deleteById(id);
	}


	@Override
	public void borrow(Library library , Integer usedCode) {
		List<CodeBook>codeBookList =codeBookService.findAllCodeByBookId((library.getId()));
		for (CodeBook codeBook : codeBookList) {
			if (codeBook.getCodeBook().equals(usedCode)) {
				codeBook.setStatus(new Status(2, "used"));
				break;
			}
		}
		library.borrow();
		libraryRepository.save(library);
	}

	@Override
	public void returnLibrary(Library library , Integer returnCode) throws NotAvailableException, WrongCodeException {
		List<CodeBook> codeBookList = codeBookService.findUsedCodeBookByLibraryId(library.getId());
		if (codeBookList.size() == 0) {
			throw new NotAvailableException();
		}

		boolean isCorrectCode = false;
		for (CodeBook codeBook : codeBookList) {
			if (codeBook.getCodeBook().equals(returnCode)) {
				codeBook.setStatus(new Status(1, "available"));
				codeBookService.save(codeBook);
				library.returnBook();
				libraryRepository.save(library);
				isCorrectCode = true;
				break;
			}
		}
		if (!isCorrectCode) {
			throw new WrongCodeException();
		}
	}

	@Override
	public Library findById(Integer id) {
		return libraryRepository.findById(id).orElse(null);
	}

	@Override
	public CodeBook getNextAvailableCodeBook(Library library) throws NotAvailableException {
		List<CodeBook> codeBookList = codeBookService.findAvailableCodeBookByLibraryId(library.getId());
		if (codeBookList.size() == 0) {
			throw new NotAvailableException();
		}
		return codeBookList.get(0);
	}

	@Override
	public void returnBook(Library library, Integer returnCode) throws NotAvailableException, WrongCodeException {
		List<CodeBook> codeBookList = codeBookService.findUsedCodeBookByLibraryId(library.getId());
		if (codeBookList.size() == 0) {
			throw new NotAvailableException();
		}

		boolean isCorrectCode = false;
		for (CodeBook codeBook : codeBookList) {
			if (codeBook.getCodeBook().equals(returnCode)) {
				codeBook.setStatus(new Status(1, "available"));
				codeBookService.save(codeBook);
				library.returnBook();
				libraryRepository.save(library);
				isCorrectCode = true;
				break;
			}
		}
		if (!isCorrectCode) {
			throw new WrongCodeException();
		}
	}

	@Override
	public boolean checkNoUsedCode(Library library) {
		return false;
	}
}
