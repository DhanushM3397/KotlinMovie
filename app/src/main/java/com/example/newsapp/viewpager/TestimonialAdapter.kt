package com.example.newsapp.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.BR
import com.example.newsapp.modelClass.Tv_shows


class TestimonialAdapter : ListAdapter<Tv_shows, TestimonialViewHolder>(
    TestimonialItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return TestimonialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestimonialViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun getItemViewType(position: Int) = R.layout.viewtestimonial_layout
}

class TestimonialItemDiffCallback : DiffUtil.ItemCallback<Tv_shows>() {
    override fun areItemsTheSame(oldItem: Tv_shows, newItem: Tv_shows): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Tv_shows, newItem: Tv_shows): Boolean =
        oldItem == newItem
}

class TestimonialViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(testimonial: Tv_shows) {
        binding.setVariable(BR.imageq, testimonial)
        // binding.image= testimonial
        binding.executePendingBindings()
    }

}
