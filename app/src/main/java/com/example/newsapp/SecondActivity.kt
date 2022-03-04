package com.example.newsapp


import android.annotation.SuppressLint
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.DaoDatabase.EpisodeEntiity

import com.example.newsapp.coroutine.ListviewModel
import com.example.newsapp.coroutine.Roomviewmodel


import com.example.newsapp.databinding.ActivitySecondBinding
import com.example.newsapp.fragments.BlankFragment


class SecondActivity : AppCompatActivity() {
    lateinit var activitySecondBinding: ActivitySecondBinding
    private lateinit var model: Roomviewmodel
    private lateinit var entiity: EpisodeEntiity

    private lateinit var viewModel: ListviewModel
    lateinit var  retrivethedata:List<EpisodeEntiity>


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
    Episodes()
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

    private fun watchlist() {
        activitySecondBinding.btWatchlist.setOnClickListener {
            viewModel.mutableEpisodeLiveData.observe(this, {
                entiity = EpisodeEntiity(
                    it.ep_tvShows.id,
                    it.ep_tvShows.name,
                    it.ep_tvShows.url,
                    it.ep_tvShows.description,
                    it.ep_tvShows.start_date,
                    it.ep_tvShows.country,
                    it.ep_tvShows.image_thumbnail_path,
                    it.ep_tvShows.rating,
                  /* it.ep_tvShows.genres[0],
                    it.ep_tvShows.network,
                    it.ep_tvShows.episodes[0].season,
                    it.ep_tvShows.episodes[0].air_date*/)
                model.insert(entiity)

            })
        }
    }

    private fun Episodes() {
        activitySecondBinding.btEpisodes.setOnClickListener {

            /* val blankFragment = BlankFragment().newInstance()
             blankFragment.show(supportFragmentManager, blankFragment.tag)*/

          model.students.observe(this, {name->
           Log.d("shs",name[0].country)
              Toast.makeText(this,"messagae"+name[0].country,Toast.LENGTH_LONG).show()

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