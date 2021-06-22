package com.example.recipe_apps.repository

import com.example.recipe_apps.api.ApiService
import javax.inject.Inject

class RecipeRepository
@Inject constructor(private val apiService: ApiService)
{
    suspend fun getRecipe() =apiService.getRecipe()
}