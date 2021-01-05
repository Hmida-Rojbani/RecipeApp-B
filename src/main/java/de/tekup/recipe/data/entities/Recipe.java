package de.tekup.recipe.data.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private LocalTime prepTime;
	
	private LocalTime cookTime;
	
	private Integer servings;
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	@Lob
	private String directions;
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
	List<Ingredient> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
		
	}

}
