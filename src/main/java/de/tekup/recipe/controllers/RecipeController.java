package de.tekup.recipe.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.dto.models.RecipeRequest;
import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecipeController {
	private RecipeService service;
	private ModelMapper mapper;
	
	@GetMapping("/recipe/{id}/show")
	public String showRecipe(@PathVariable("id") long id, Model model) {
		model.addAttribute("recipe", service.getRecipeById(id));
		return "recipe/show";
	}
	
	@GetMapping("/recipe/{id}/delete")
	public String deleteRecipe(@PathVariable("id") long id) {
		service.deleteRecipeById(id);
		return "redirect:/"; 
	}
	
	@GetMapping("/recipe/{id}/update")
	public String updateRecipe(@PathVariable("id") long id, Model model) {
		RecipeRequest request = mapper.map(service.getRecipeById(id),RecipeRequest.class);
		model.addAttribute("recipe",request);
		return "recipe/recipeform";
	}
	
	@GetMapping("/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe",new RecipeRequest());
		return "recipe/recipeform";
	}
	
	@PostMapping("/recipe")
	public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeRequest request, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "recipe/recipeform";
		}
		
		Recipe recipe = mapper.map(request, Recipe.class);
		service.saveOrUpdate(recipe);
		return "redirect:/";
	}
}
