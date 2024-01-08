package com.muema.recipe_91860.ui.recipe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.muema.recipe_91860.data.SAMPLERECIPES
import com.muema.recipe_91860.databinding.FragmentRecipeDetailBinding
import com.muema.recipe_91860.model.Ingredient

class RecipeDetailsFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    val detailArgs:RecipeDetailsFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)


        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipe = SAMPLERECIPES.find { recipeModel ->  recipeModel.id == detailArgs.recipeid } ?: SAMPLERECIPES.first()

     binding.apply {

         recipeName.text = recipe.name
         textViewDifficultyLevel.text = buildString {
        append("Difficulty: ")
        append(recipe.difficultyLevel.name)
        append("  \n\nType:")
        append(recipe.mealType.name)
    }
         textViewIngredients.text = buildString {
        append("Ingredients:\n")
        append(formatIngredients(recipe.ingredients))
    }

         textViewSteps.text =  buildString {
        append("Steps:\n")
        append(formatSteps(recipe.steps))
    }

         textViewServings.text = "Servings: ${recipe.servings}"

     }


    }


    private fun formatIngredients(ingredients: List<Ingredient>): String {
        val formattedIngredients = StringBuilder()
        for (ingredient in ingredients) {
            formattedIngredients.append("- ${ingredient.name} - ${ingredient.amount}\n")
        }
        return formattedIngredients.toString()
    }


    private fun formatSteps(steps: List<String>): String {
        val formattedSteps = StringBuilder()
        for ((index, step) in steps.withIndex()) {
            formattedSteps.append("${index + 1}. $step\n")
        }
        return formattedSteps.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}