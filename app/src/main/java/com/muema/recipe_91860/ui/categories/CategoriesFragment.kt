package com.muema.recipe_91860.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.muema.recipe_91860.databinding.FragmentCategoriesBinding
import com.muema.recipe_91860.databinding.FragmentNotificationsBinding
import com.muema.recipe_91860.model.RecipeType

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.breakfastCard.setOnClickListener {
            navigateToCategoryRecipes(RecipeType.Breakfast.name)
        }

        binding.lunchCard.setOnClickListener {
            navigateToCategoryRecipes(RecipeType.Lunch.name)
        }
        binding.supperCard.setOnClickListener {
            navigateToCategoryRecipes(RecipeType.Supper.name)
        }
        binding.snackCard.setOnClickListener {
            navigateToCategoryRecipes(RecipeType.Snack.name)
        }
    }

    private fun navigateToCategoryRecipes(category:String){

        val action = CategoriesFragmentDirections.actionNavigationCategoryToCategoryRecipes(category)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}