package com.muema.recipe_91860

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.muema.recipe_91860.data.SAMPLERECIPES
import com.muema.recipe_91860.databinding.FragmentCategoryRecipesBinding
import com.muema.recipe_91860.databinding.FragmentHomeBinding
import com.muema.recipe_91860.model.RecipeType
import com.muema.recipe_91860.ui.home.HomeFragmentDirections
import com.muema.recipe_91860.ui.home.RecipeListAdapter


class CategoryRecipes : Fragment() {

    private var _binding: FragmentCategoryRecipesBinding? = null


    private val binding get() = _binding!!
    private lateinit var recipeListAdapter: RecipeListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val args : CategoryRecipesArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentCategoryRecipesBinding.inflate(inflater,container,false)

        (activity as AppCompatActivity).supportActionBar?.title = "${args.category} Recipes"

        linearLayoutManager = LinearLayoutManager(requireContext(),)
        recipeListAdapter = RecipeListAdapter {
            val action = CategoryRecipesDirections.actionCategoryRecipesToNavigationDetails(it)
            findNavController().navigate(action)
        }

        binding.recipeHomeAdapter.apply {
            adapter = recipeListAdapter
            layoutManager = linearLayoutManager
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = RecipeType.valueOf(args.category)
        val recipes = SAMPLERECIPES.filter {
            it.mealType == category
        }

        recipeListAdapter.submitList(recipes)
    }


}