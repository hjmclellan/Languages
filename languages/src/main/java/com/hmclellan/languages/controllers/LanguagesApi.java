package com.hmclellan.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hmclellan.languages.models.Languages;
import com.hmclellan.languages.services.LanguagesService;

@RestController
public class LanguagesApi {
	private final LanguagesService languagesService;
	
	public LanguagesApi(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}
	
	@RequestMapping("/api/languages")
	public List<Languages> index() {
		return languagesService.findAll();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
	public Languages create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Languages lang = new Languages(name,creator,version);
		return languagesService.createLanguages(lang);
	}
	
	@RequestMapping("/api/languages/{id}")
	public Languages show(@PathVariable("id") Long id) {
		Languages lang = languagesService.findOne(id);
		return lang;
	}
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
	public Languages update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Languages lang = languagesService.updateLanguages(id, name, creator, version);
		return lang;
	}
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		languagesService.deleteLanguages(id);
	}
}