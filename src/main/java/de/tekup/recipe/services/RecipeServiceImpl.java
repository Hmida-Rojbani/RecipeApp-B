package de.tekup.recipe.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.recipe.data.entities.Recipe;
import de.tekup.recipe.data.repositories.RecipeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository reposRecipe;

	@Override
	public List<Recipe> getRecipes() {
		return reposRecipe.findAll();
	}

	@Override
	public Recipe getRecipeById(long id) {
		
		return reposRecipe.findById(id)
				.orElseThrow(()-> new NoSuchElementException("Recipe with this id is not found"));
	}

	@Override
	public void deleteRecipeById(long id) {
		reposRecipe.deleteById(id);
		 
	}

	@Override
	public void saveOrUpdate(Recipe recipe) {
		reposRecipe.save(recipe);
		
	}

}
