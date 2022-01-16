package com.example.newsapp.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.PagingviewadapteritemBinding
import com.example.newsapp.modelClass.JsonRootclass
import com.example.newsapp.modelClass.Tv_shows

class PagingTvlistAdapter(private val onPagingItemClick: OnPagingItemClick) :
    PagingDataAdapter<JsonRootclass, PagingTvlistAdapter.TvlistviewHolder>(
        newdif
    ) {
    var characterClickListener: CharacterClickListener? = null

    inner class TvlistviewHolder(val pagingviewdataholder: PagingviewadapteritemBinding) :
        RecyclerView.ViewHolder(pagingviewdataholder.root) {

        init {
            itemView.setOnClickListener {
                characterClickListener?.onCharacterClicked(
                    pagingviewdataholder,
                    getItem(absoluteAdapterPosition)?.tv_shows?.get(absoluteAdapterPosition) as Tv_shows
                )
            }
        }


        fun bind1(item1: Tv_shows) = with(pagingviewdataholder) {
            pagingview = item1
        }
    }


    override fun onBindViewHolder(holder: TvlistviewHolder, position: Int) {

        // holder.bind1(getItem(it.tv_shows[position])!!)

        try {
            getItem(position)?.let {
                holder.bind1(it.tv_shows[position])
                holder.itemView.setOnClickListener {
                    getItem(position)?.let { it1 -> onPagingItemClick.onClick(it1) }
                }

            }

        } catch (e: Exception) {
            e.localizedMessage
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvlistviewHolder {
        val paginglayout =
            PagingviewadapteritemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvlistviewHolder(paginglayout)
    }


    object newdif : DiffUtil.ItemCallback<JsonRootclass>() {

        override fun areItemsTheSame(oldItem: JsonRootclass, newItem: JsonRootclass): Boolean {
            return oldItem.page == newItem.page
        }


        override fun areContentsTheSame(oldItem: JsonRootclass, newItem: JsonRootclass): Boolean {
            return oldItem.page == newItem.page
        }


    }

    interface CharacterClickListener {
        fun onCharacterClicked(binding: PagingviewadapteritemBinding, character: Tv_shows)
    }

    //--------------on Event listner ----------------------------------
    class OnPagingItemClick(val clickListener: (meme: JsonRootclass) -> Unit) {
        fun onClick(meme: JsonRootclass) = clickListener(meme)
    }


}