package com.hmclellan.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hmclellan.languages.models.Languages;
import com.hmclellan.languages.services.LanguagesService;


@Controller
public class LanguageController {
	private final LanguagesService languagesService;
	
	public LanguageController(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Languages> languages = languagesService.findAll();
		model.addAttribute("languages", languages);
		model.addAttribute("language", new Languages());
		return "/languages/index.jsp";
	}
	
	
	@RequestMapping(value="languages/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Languages lang = languagesService.findOne(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
	
	@RequestMapping("/languages/{id}/editor")
	public String editor(@PathVariable("id") Long id, Model model) {
		Languages lang = languagesService.findOne(id);
		model.addAttribute("language", lang);
		return "/languages/editor.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("language")Languages lang, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "/languages/index.jsp";
		} else {
			languagesService.createLanguages(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		languagesService.updateLanguages(id, name, creator, version);
		return "redirect:/languages";
	}
	
	@RequestMapping(value="languages/{id}", method=RequestMethod.DELETE)
	public String deleteOne(@PathVariable("id") Long id) {
		languagesService.deleteLanguages(id);
		return "redirect:/languages";
	}
}