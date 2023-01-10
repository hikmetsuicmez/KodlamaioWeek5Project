package com.hikmetsuicmez.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hikmetsuicmez.entities.Language;
import com.hikmetsuicmez.entities.Technology;
import com.hikmetsuicmez.repository.TechnologyRepository;
import com.hikmetsuicmez.requests.TechnologyCreateRequest;
import com.hikmetsuicmez.requests.TechnologyUpdateRequest;

@Service
public class TechnologyService {

	private TechnologyRepository technologyRepository;
	private LanguageService languageService;

	public TechnologyService(TechnologyRepository technologyRepository, LanguageService languageService) {
		this.technologyRepository = technologyRepository;
		this.languageService = languageService;

	}

	public List<Technology> getAllTechnologies(Optional<Long> languageId) {
		if (languageId.isPresent()) {
			return technologyRepository.findByLanguageId(languageId.get());
		} else
			return technologyRepository.findAll();
	}

	public Technology getOneTechnologyById(Long technology_id) {
		return technologyRepository.findById(technology_id).orElse(null);
	}

	public Technology createTechnology(TechnologyCreateRequest request) {
		Language language = languageService.getOneLanguageById(request.getLanguageId());
		if (language == null) 
			return null;
		Technology createToSave = new Technology();
		createToSave.setId(request.getId());
		createToSave.setTechnologyName(request.getTechnologyName());
		createToSave.setText(request.getText());
		createToSave.setLanguage(language);
		return technologyRepository.save(createToSave);

	}

	public Technology updateTechnology(Long technology_id, TechnologyUpdateRequest request) {
		Optional<Technology> technology = technologyRepository.findById(technology_id);
		if (technology.isPresent()) {
			Technology toUpdate = technology.get();
			toUpdate.setTechnologyName(request.getTechnologyName());
			toUpdate.setText(request.getText());
			return technologyRepository.save(toUpdate);
		}
		return null;
	}

	public void deleteTechnologyById(Long technology_id) {
		technologyRepository.deleteById(technology_id);
	}

}
