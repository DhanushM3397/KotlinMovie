package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.DaoDatabase.EpisodeEntiity
import com.example.newsapp.databinding.BottomLayoutAdapterItemBinding
import com.example.newsapp.modelClass.Tv_shows

class BottomSheetAdapter /*: RecyclerView.Adapter<BottomSheetAdapter.BottomViewHolder>()*/ {

    /*inner class BottomViewHolder(val bottomlayout: BottomLayoutAdapterItemBinding) :
        RecyclerView.ViewHolder(bottomlayout.root) {

       *//* fun bind(item: EpisodeEntiity)  = with(bottomlayout){
       bottom=item
       }*//*

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomViewHolder {
        val layout = BottomLayoutAdapterItemBinding.inflate(LayoutInflater.from(parent.context))
        return BottomViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BottomViewHolder, position: Int) {
        holder.apply {
            //bind(item = differ.currentList[position])
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    object newdif : DiffUtil.ItemCallback<EpisodeEntiity>() {

        override fun areItemsTheSame(oldItem: EpisodeEntiity, newItem: EpisodeEntiity): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: EpisodeEntiity, newItem: EpisodeEntiity): Boolean {
            return oldItem.id == newItem.id
        }

    }*/

   /* val differ = AsyncListDiffer(this, newdif)


    fun bottomsublist(newsinfo:List<EpisodeEntiity>) {
        differ.submitList(newsinfo)
    }*/
}