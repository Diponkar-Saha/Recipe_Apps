package com.example.recipe_apps.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeX(
    val id: String,
    val imageUrl: String,
    val publishedId: String,
    val publisher: String,
    val socialUrl: Double,
    val sourceUrl: String,
    val title: String
) : Parcelable