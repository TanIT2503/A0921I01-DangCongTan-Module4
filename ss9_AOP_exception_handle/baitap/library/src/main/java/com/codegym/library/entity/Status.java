package com.codegym.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String status;

	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<CodeBook> codeBokAvailableSet;

	public Status(Integer id) {
		this.id = id;
	}

	public Status(Integer id, String status) {
		this.id = id;
		this.status = status;
	}
}
