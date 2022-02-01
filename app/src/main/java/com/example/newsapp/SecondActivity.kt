package com.example.newsapp


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.newsapp.coroutine.ListviewModel
import com.example.newsapp.coroutine.Roomviewmodel


import com.example.newsapp.databinding.ActivitySecondBinding
import com.example.newsapp.modelClass.episode_information.Episode_Tvshows


class SecondActivity : AppCompatActivity() {
    lateinit var activitySecondBinding: ActivitySecondBinding
    private lateinit var model: Roomviewmodel


    private lateinit var viewModel: ListviewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val urlId: String = intent.getStringExtra("id").toString()


        activitySecondBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_second)// initialization
            model = ViewModelProvider(this).get(Roomviewmodel::class.java)

        try {

            initViewModel1(urlId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        viewModelToViewDataBinding()
        expandableTextview()
        watchlist()
    }

    private fun viewModelToViewDataBinding() =


        //----------------data binding of View Model  to view---------------------------------------------------------
        viewModel.mutableEpisodeLiveData.observe(this, {
            activitySecondBinding.epiDesc = it

            activitySecondBinding.isLoadingMore = false
        })


    private fun initViewModel1(id: String) {
        activitySecondBinding.isLoadingMore = true
        //   viewModel = of(this).get(ListviewModel::class.java)    or

        viewModel = ViewModelProvider(this).get(ListviewModel::class.java)

        viewModel.EpisodesInformation(id)


    }
 private  fun  watchlist(){
     activitySecondBinding.btWatchlist.setOnClickListener {
         viewModel.mutableEpisodeLiveData.observe(this, {
             model.insert(it.ep_tvShows)
         })
     }
 }
    @SuppressLint("SetTextI18n")
    private fun expandableTextview() {
        activitySecondBinding.textSeeMore.setOnClickListener {
            if (activitySecondBinding.textSeeMore.text.equals("ReadMore...")) {
                activitySecondBinding.textView5.maxLines = Int.MAX_VALUE
                activitySecondBinding.textSeeMore.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_arrow_up,
                    0
                )
                activitySecondBinding.textSeeMore.text = "ReadLess..."

            } else {
                activitySecondBinding.textView5.maxLines = 3
                activitySecondBinding.textSeeMore.text = "ReadMore..."
                activitySecondBinding.textSeeMore.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_down_arrow_down,
                    0
                )

            }
        }
    }

}