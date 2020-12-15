package de.tekup.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
	private RecipeService service;
	
	@GetMapping({"","/","index"})
	public String getIndex(Model model) {
		model.addAttribute("recipes", service.getRecipes());
		return "index";
	}

}
