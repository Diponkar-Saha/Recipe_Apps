package com.example.recipe_apps.api

import com.example.recipe_apps.models.Recipe
import com.example.recipe_apps.util.Constants.END_URL
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_URL)
    suspend fun getRecipe():Response<Recipe>
}