package com.muema.recipe_91860.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.muema.recipe_91860.databinding.HomeRecipeRecyclerlistBinding
import com.muema.recipe_91860.model.RecipeModel

class RecipeListAdapter (private val onClickRecipe : (id:Int) -> Unit): ListAdapter<RecipeModel, RecipeListAdapter.RecipeListViewHolder>(RecipeHomeListDiffUtil) {







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        return RecipeListViewHolder(
            HomeRecipeRecyclerlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
val item = getItem(position)
        holder.bind(item)
    }

    inner class RecipeListViewHolder (private val binding: HomeRecipeRecyclerlistBinding): ViewHolder(binding.root) {
        fun bind(recipe : RecipeModel){

            recipe.apply {
                binding.root.setOnClickListener {

                    onClickRecipe(recipe.id)
                }

                binding.recipeName.text = name
                binding.difficulty.text = difficultyLevel.name
            }


        }



    }
}

object RecipeHomeListDiffUtil : DiffUtil.ItemCallback<RecipeModel>() {

    override fun areItemsTheSame(oldItem: RecipeModel, newItem: RecipeModel): Boolean {

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecipeModel, newItem: RecipeModel): Boolean {

        return oldItem == newItem
    }


}