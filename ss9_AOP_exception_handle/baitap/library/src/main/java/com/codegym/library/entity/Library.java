package com.codegym.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;
	private String author;
	private String year;
	private Integer quantity;

	@OneToMany(mappedBy = "library", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<CodeBook> codeBookSet = new LinkedHashSet<>();

	public void generateCode(CodeBook codeBook){
		codeBookSet.add(codeBook);
	}
	public void borrow() {
		if (quantity > 0) quantity--;
	}

	public void returnBook() {
		quantity++;
	}
}
