package com.muema.recipe_91860.ui.onboarding

import com.muema.recipe_91860.R

data class OnboardingModel(
    val image : Int,
    val description : String
)
val onBoardingData = listOf(
    OnboardingModel(
        R.drawable.recipe_64,
        "Get Hundreds of Recipes from all over the world tailored for you"
    ),

    OnboardingModel(
        R.drawable.chef,
        "Explore a variety of recipes, meal plans, and cooking tips at your fingertips."
    ),

    OnboardingModel(
        R.drawable.list,
        "Unlock the joy of cooking with step-by-step instructions and handy tips."
    )
)