package com.hikmetsuicmez.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "language")
@Data
public class Language {

	@Id
	Long id;
	String languageName;
	String difficulty;

}
