package com.codegym.library.controller;

import com.codegym.library.entity.CodeBook;
import com.codegym.library.entity.Library;
import com.codegym.library.exception.NotAvailableException;
import com.codegym.library.exception.WrongCodeException;
import com.codegym.library.service.CodeBookService;
import com.codegym.library.service.LibraryService;
import com.codegym.library.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CodeBookBorrowController {
    @Autowired
    LibraryService libraryService;

    @Autowired
    CodeBookService codeBookService;

    @Autowired
    StatusService statusService;

    @GetMapping("/view")
    public String view(Model model) {
        List<CodeBook> codeBookBorrowList = codeBookService.findAll();
        model.addAttribute("codeBookBorrowList", codeBookBorrowList);
        return "codebook/viewcode";
    }

    @GetMapping("/returnCode")
    public String returnPage(Model model, @RequestParam Integer id) {

        CodeBook codeBook = codeBookService.findById(id);
        Library library=codeBook.getLibrary();

        model.addAttribute("library", library);
        model.addAttribute("codeBook",codeBook);
        return "codebook/returnbook";
    }
    @PostMapping("/returnCode")
    public String returnBook(Model model, @ModelAttribute Library library, @ModelAttribute CodeBook codeBook) throws WrongCodeException, NotAvailableException {

        libraryService.returnBook(library,codeBook.getCodeBook());
        return "redirect:/";
    }
}
