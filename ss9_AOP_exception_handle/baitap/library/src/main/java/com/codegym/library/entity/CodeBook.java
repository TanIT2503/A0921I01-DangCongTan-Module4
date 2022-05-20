package com.codegym.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private  Integer codeBook;

	@ManyToOne(targetEntity = Library.class)
	private Library library;

	@ManyToOne(targetEntity = Status.class)
	private Status status;

	public CodeBook(Integer codeBook) {
		this.codeBook = codeBook;
	}

	public CodeBook(Integer codeBook, Library library) {
		this.codeBook = codeBook;
		this.library = library;
	}

	public CodeBook(Integer codeBook, Library library, Status status) {
		this.codeBook = codeBook;
		this.library = library;
		this.status = status;
	}

	public Integer getCodeBook() {
		return codeBook;
	}

	public void setCodeBook(Integer codeBook) {
		this.codeBook = codeBook;
	}
}
