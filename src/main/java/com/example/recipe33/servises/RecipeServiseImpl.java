package com.example.recipe33.servises;

import com.example.recipe33.model.RecipeModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiseImpl implements RecipeServise {
    private Map<Long, RecipeModel> receipesMap = new HashMap<>();
    private static Long recipeId = 1L;
    @Override
    public long addReсipe(RecipeModel receipe) {
        Map<Long, RecipeModel> recipes = receipesMap;
        recipes.put(recipeId, receipe);
        receipesMap.put(recipeId, receipe);
        return recipeId++;
    }

    @Override
    public RecipeModel getRecipe(Long id) {
        {
            if (receipesMap.containsKey(id)) {
                return receipesMap.get(id);
            }
            return null;
        }
    }

    @Override
    public void getAllRecipes() {
       receipesMap = new HashMap<>();
    }

    @Override
    public RecipeModel editRecipe(Long id, RecipeModel recipeModelNew) {
        if (receipesMap.containsKey(id)) {
            return receipesMap.put(recipeId, recipeModelNew);
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(Long id) {
        var removed = receipesMap.remove(id);
        return removed != null;
    }
            }

