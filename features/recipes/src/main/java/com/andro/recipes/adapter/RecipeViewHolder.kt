package com.andro.recipes.adapter

import androidx.recyclerview.widget.RecyclerView
import com.andro.domain.dto.recipes.RecipesItem
import com.andro.recipes.adapter.RecyclerItemListener
import com.andro.recipes.R
import com.andro.recipes.databinding.RecipeItemBinding
import com.squareup.picasso.Picasso

class RecipeViewHolder(private val itemBinding: RecipeItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(recipesItem: RecipesItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.tvCaption.text = recipesItem.description
        itemBinding.tvName.text = recipesItem.name
        Picasso.get().load(recipesItem.thumb).placeholder(R.drawable.ic_healthy_food).error(R.drawable.ic_healthy_food)
            .into(itemBinding.ivRecipeItemImage)
        itemBinding.rlRecipeItem.setOnClickListener { recyclerItemListener.onItemSelected(recipesItem) }
    }
}

