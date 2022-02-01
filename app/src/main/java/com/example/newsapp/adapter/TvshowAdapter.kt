package com.example.newsapp.adapter



import android.media.MediaDrm
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.AdapterItemLayoutBinding
import com.example.newsapp.modelClass.Tv_shows



class TvshowAdapter(private val onClickListener: OnClickListener)  : RecyclerView.Adapter<TvshowAdapter.NewsViewHolder>() {


    inner class NewsViewHolder(val adapteritemlist: AdapterItemLayoutBinding) :
        RecyclerView.ViewHolder(adapteritemlist.root) {

        fun bind(item: Tv_shows) = with(adapteritemlist) {
            news = item
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val newslistbinding =
            AdapterItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NewsViewHolder(newslistbinding)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.apply {
            bind(item = differ.currentList[position])
        }

        //--------------on Event listner ----------------------------------
        holder.itemView.setOnClickListener {
            onClickListener.onClick(differ.currentList[position])
        }



    }
    //--------------on Event listner ----------------------------------
    class OnClickListener(val clickListener: (meme: Tv_shows) -> Unit) {
        fun onClick(meme: Tv_shows) = clickListener(meme)
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }



    object newdif : DiffUtil.ItemCallback<Tv_shows>() {

        override fun areItemsTheSame(oldItem: Tv_shows, newItem: Tv_shows): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: Tv_shows, newItem: Tv_shows): Boolean {
            return oldItem.id == newItem.id
        }

    }

    val differ = AsyncListDiffer(this, newdif)


    fun sublist(newsinfo: ArrayList<Tv_shows>) {
        differ.submitList(newsinfo)
    }


}