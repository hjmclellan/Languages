package com.hmclellan.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hmclellan.languages.models.Languages;
import com.hmclellan.languages.repositories.LanguageRepository;

@Service
public class LanguagesService {
	private final LanguageRepository languageRepository;
	
	public LanguagesService (LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Languages> findAll() {
		return languageRepository.findAll();
	}
	
	public Languages findOne (Long id) {
		Optional<Languages> optionalLanguages = languageRepository.findById(id);
		if(optionalLanguages.isPresent()) {
			return optionalLanguages.get();
		} else {
			return null;
		}
	}
	
	public Languages createLanguages(Languages l) {
		return languageRepository.save(l);
	}
	
	public void deleteLanguages (Long id) {
		languageRepository.deleteById(id);
	}
	
	public Languages updateLanguages(Long id, String name, String creator, String version) {
		if (languageRepository.findById(id).isPresent()) {
			Languages lang = languageRepository.findById(id).get();
			lang.setName(name);
			lang.setCreator(creator);
			lang.setVersion(version);
			return languageRepository.save(lang);
		} else {
			return null;
		}
	}
}