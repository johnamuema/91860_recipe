package com.muema.recipe_91860.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import com.muema.recipe_91860.databinding.OnboardingLayoutAdapterBinding

class OnboardingAdapter( private val onEvent : (OnboardingEvent) -> Unit) :
    ListAdapter<OnboardingModel, OnboardingAdapter.OnboardingViewHolder>(OnboardingDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OnboardingLayoutAdapterBinding.inflate(inflater, parent, false)
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val onboardingItem = getItem(position)
        holder.bind(onboardingItem,position)
    }

    inner class OnboardingViewHolder(private val binding: OnboardingLayoutAdapterBinding) :
        ViewHolder(binding.root) {

        fun bind(onboardingItem: OnboardingModel,position: Int) {
            if (position == 0){
                binding.previousButton.visibility = View.GONE
                binding.nextButton.visibility = View.VISIBLE
                binding.finishButton.visibility = View.GONE
            } else if (position == 1){
                binding.previousButton.visibility = View.VISIBLE
                binding.nextButton.visibility = View.VISIBLE
                binding.finishButton.visibility = View.GONE
            } else{
                binding.previousButton.visibility = View.VISIBLE
                binding.nextButton.visibility = View.GONE
                binding.finishButton.visibility = View.VISIBLE
            }

            binding.previousButton.setOnClickListener { onEvent(OnboardingEvent.Previous(position -1)) }
            binding.nextButton.setOnClickListener { onEvent(OnboardingEvent.Next(position +1)) }
            binding.finishButton.setOnClickListener { onEvent(OnboardingEvent.Finish) }

            binding.onBoardingImage .setImageResource(onboardingItem.image)
            binding.onboardingText .text = onboardingItem.description


        }
    }


    private class OnboardingDiffCallback : DiffUtil.ItemCallback<OnboardingModel>() {
        override fun areItemsTheSame(oldItem: OnboardingModel, newItem: OnboardingModel): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: OnboardingModel, newItem: OnboardingModel): Boolean {
            return oldItem == newItem
        }
    }
}


sealed class OnboardingEvent{
     data class Previous(val position: Int) : OnboardingEvent()
    data class Next(val position: Int): OnboardingEvent(
    )
    data object  Finish : OnboardingEvent()
}