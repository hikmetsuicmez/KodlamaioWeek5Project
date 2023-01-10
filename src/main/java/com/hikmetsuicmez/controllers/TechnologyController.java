package com.hikmetsuicmez.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hikmetsuicmez.entities.Technology;
import com.hikmetsuicmez.requests.TechnologyCreateRequest;
import com.hikmetsuicmez.requests.TechnologyUpdateRequest;
import com.hikmetsuicmez.service.TechnologyService;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

	private TechnologyService technologyService;

	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping
	public List<Technology> getAllTechnologies(@RequestParam Optional<Long> languageId) {
		return technologyService.getAllTechnologies(languageId);
	}

	@GetMapping("/{technology_id}")
	public Technology getOneTechnology(@PathVariable Long technology_id) {
		return technologyService.getOneTechnologyById(technology_id);
	}
	
	@PostMapping
	public Technology createTechnology(@RequestBody TechnologyCreateRequest request) {
		return technologyService.createTechnology(request);
	}
	
	@PutMapping("/{technology_id}")
	public Technology updateTechnology(@PathVariable Long technology_id,@RequestBody TechnologyUpdateRequest request) {
		return technologyService.updateTechnology(technology_id,request);
	}
	
	@DeleteMapping("/{technology_id}")
	public void deleteTechnology(@PathVariable Long technology_id) {
		technologyService.deleteTechnologyById(technology_id);
	}
	

}
