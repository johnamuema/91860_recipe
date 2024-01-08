package com.muema.recipe_91860.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.muema.recipe_91860.data.SAMPLERECIPES
import com.muema.recipe_91860.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var recipeListAdapter: RecipeListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
       linearLayoutManager = LinearLayoutManager(requireContext(),)
        recipeListAdapter = RecipeListAdapter {
val action = HomeFragmentDirections.actionNavigationHomeToNavigationDetails(it)
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
        recipeListAdapter.submitList(SAMPLERECIPES)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}