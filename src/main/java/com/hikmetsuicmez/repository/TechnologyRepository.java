package com.hikmetsuicmez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hikmetsuicmez.entities.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

	List<Technology> findByLanguageId(Long languageId);

}
