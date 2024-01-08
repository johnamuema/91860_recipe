package com.muema.recipe_91860.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muema.recipe_91860.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

private var _binding : FragmentOnboardingBinding? = null

private val binding get() = _binding!!

    private lateinit var onBoardingAdapter : OnboardingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater,container,false)
        onBoardingAdapter = OnboardingAdapter{event ->
            when(event){
                OnboardingEvent.Finish -> {
                    val action = OnboardingFragmentDirections.actionOnboardingFragmentToNavigationHome()
                    findNavController().navigate(action)
                }
                is OnboardingEvent.Next -> {
                    binding.onBoardingViewPager.setCurrentItem(event.position,true)
                }
                is OnboardingEvent.Previous -> {
                    binding.onBoardingViewPager.setCurrentItem(event.position,true)
                }
            }

        }.apply {
            submitList(onBoardingData)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onBoardingViewPager.adapter = onBoardingAdapter

    }

}