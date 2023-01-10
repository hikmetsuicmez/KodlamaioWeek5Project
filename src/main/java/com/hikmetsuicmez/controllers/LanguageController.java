package com.hikmetsuicmez.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hikmetsuicmez.entities.Language;
import com.hikmetsuicmez.service.LanguageService;

@RestController
@RequestMapping("/languages")
public class LanguageController {

	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping
	public List<Language> getAllLanguages() {
		return languageService.getAllLanguages();
	}
	
	@GetMapping("/{language_id}")
	public Language getOneLanguage(@PathVariable Long language_id) {
		return languageService.getOneLanguageById(language_id);
	}
	
	@PostMapping
	public Language createLanguage(@RequestBody Language newLanguage) {
		return languageService.createLanguage(newLanguage);
	}
	
	@DeleteMapping("/{language_id}")
	public void deleteLanguage(@PathVariable Long language_id) {
		languageService.deleteLanguage(language_id);
	}
	
	@PutMapping("/{languageId}")
	public Language updateLanguage(@PathVariable Long languageId,@RequestBody Language language) {
		return languageService.updateLanguage(languageId,language);
	}
	
}
