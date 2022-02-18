package com.andro.recipes.adapter

import com.andro.domain.dto.recipes.RecipesItem

interface RecyclerItemListener {
    fun onItemSelected(recipe : RecipesItem)
}
