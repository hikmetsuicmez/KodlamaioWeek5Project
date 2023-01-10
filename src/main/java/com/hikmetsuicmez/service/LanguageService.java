package com.hikmetsuicmez.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hikmetsuicmez.entities.Language;
import com.hikmetsuicmez.repository.LanguageRepository;

@Service
public class LanguageService {

	private LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	public Language getOneLanguageById(Long language_id) {
		return languageRepository.findById(language_id).orElse(null);
	}

	public Language createLanguage(Language newLanguage) {
		return languageRepository.save(newLanguage);
	}

	public void deleteLanguage(Long language_id) {
		languageRepository.deleteById(language_id);
	}

	public Language updateLanguage(Long languageId, Language language) {
		Optional<Language> theLanguage = languageRepository.findById(languageId);
		if (theLanguage.isPresent()) {
			Language foundLanguage = new Language();
			foundLanguage.setLanguageName(language.getLanguageName());
			foundLanguage.setDifficulty(language.getDifficulty());
			return languageRepository.save(foundLanguage);
		} else
			return null;
	}
}
