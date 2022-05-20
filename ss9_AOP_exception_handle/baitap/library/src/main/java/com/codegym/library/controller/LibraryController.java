package com.codegym.library.controller;

import com.codegym.library.entity.Library;
import com.codegym.library.exception.NotAvailableException;
import com.codegym.library.exception.NotBorrowException;
import com.codegym.library.exception.WrongCodeException;
import com.codegym.library.service.LibraryService;
import com.codegym.library.service.StatusService;
import com.codegym.library.validation.ReturnCodeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class LibraryController {
	@Autowired
	LibraryService libraryService;

	@Autowired
	StatusService statusService;
	@GetMapping("")
	public String showList(Model model){
		List<Library> libraries = libraryService.findAll();
		model.addAttribute("libraries", libraries);
		return "/index";
	}
	@GetMapping("/create")
	public String getBook(Model model){
		model.addAttribute("library", new Library());
		return "library/create";
	}

	@PostMapping("/create")
	public String saveBook(@Validated @ModelAttribute("library") Library library, BindingResult bindingResult){
		if(bindingResult.hasFieldErrors()){
			return"library/create";
		}
		libraryService.save(library);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		libraryService.delete(id);
		return "redirect:/";
	}
	@GetMapping("/borrow")
	public String borrow(Model model, @RequestParam Integer id) throws NotAvailableException {
		Library library = libraryService.findById(id);
		model.addAttribute("library", library);
		model.addAttribute("availableCode", libraryService.getNextAvailableCodeBook(library));
		return "library/borrow";
	}

	@PostMapping("/borrow")
	public String borrowBook(@ModelAttribute Library library, @RequestParam Integer usedCode) {
		libraryService.borrow(library, usedCode);
		return "redirect:/";
	}

	@GetMapping("/return")
	public String returnPage(Model model, @RequestParam Integer id, @ModelAttribute ReturnCodeWrapper returnCodeWrapper) throws NotBorrowException {
		Library library = libraryService.findById(id);
		if (libraryService.checkNoUsedCode(library)) {
			throw new NotBorrowException();
		}
		model.addAttribute("returnCodeWrapper", returnCodeWrapper);
		model.addAttribute("library", library);
		return "library/return";
	}

	@PostMapping("/return")
	public String returnBook(Model model, @ModelAttribute Library library, @Validated @ModelAttribute ReturnCodeWrapper returnCodeWrapper, BindingResult result)
			throws NotAvailableException, WrongCodeException {
		if (result.hasFieldErrors()) {
			model.addAttribute("returnCodeWrapper", returnCodeWrapper);
			model.addAttribute("library", library);
			return "library/return";
		}
		libraryService.returnLibrary(library, Integer.parseInt(returnCodeWrapper.getReturnCode()));
		return "redirect:/";
	}

	@GetMapping("/create_code_status")
	public String createCodeStatus() {
		statusService.createStatus();
		return "/";
	}
	@ExceptionHandler(NotAvailableException.class)
	public String notAvailable() {
		return "error_not_available";
	}

	@ExceptionHandler(WrongCodeException.class)
	public String wrongCode() {
		return "error_wrong_code";
	}

	@ExceptionHandler(NotBorrowException.class)
	public String notBorrow() {
		return "error_not_borrow";
	}
}
