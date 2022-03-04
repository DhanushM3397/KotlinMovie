package com.example.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.newsapp.adapter.RecylerNewsAdapter
import com.example.newsapp.adapter.TvshowAdapter
import com.example.newsapp.coroutine.ListviewModel
import com.example.newsapp.databinding.ActivitySearchBinding

import com.example.newsapp.modelClass.Tv_shows
import java.util.*
import java.util.Locale.filter
import kotlin.collections.ArrayList

class SearchActivity : AppCompatActivity() {
    lateinit var activitySearchBinding: ActivitySearchBinding
    lateinit var viewModel: ListviewModel
    private val curentpage: Int = 2
    var totalAvailble: Int = 0
    lateinit var listvalue1:ArrayList<Tv_shows>
    var tvshowAdapter: TvshowAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        doIntialization()

        activitySearchBinding.imagback.setOnClickListener {
            onBackPressed()
        }

    }

    private fun doIntialization() {


        activitySearchBinding.tvShowRecyclerview.setHasFixedSize(true)



        initViewModel(activitySearchBinding.inoutSearch.text.toString())
        observeViewModel(activitySearchBinding.inoutSearch.text.toString())
        initRecycler()

        activitySearchBinding.inoutSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
              //  filter(p0.toString())\
                observeViewModel(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    private fun initViewModel(query: String) {
        activitySearchBinding.isLoading = false
        //   viewModel = of(this).get(ListviewModel::class.java)    or
        viewModel = ViewModelProvider(this).get(ListviewModel::class.java)

        viewModel.searchViewModel(query, curentpage)

    }


    private fun initRecycler() {
        activitySearchBinding.isLoading = true

        activitySearchBinding.tvShowRecyclerview.apply {
            /* layoutManager =
                 LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)*/

            layoutManager =
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)



            setHasFixedSize(true)

            //---------onitem Click----------------------------------------
            tvshowAdapter = TvshowAdapter(TvshowAdapter.OnClickListener { name ->

                Toast.makeText(
                    this@SearchActivity,
                    "name" + name.image_thumbnail_path,
                    Toast.LENGTH_LONG
                ).show()


            })
            adapter = tvshowAdapter


        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeViewModel(text:String) {
        viewModel.search_Data.observe(this, { updateItems ->
            updateItems?.let {
                listvalue1= it as ArrayList<Tv_shows>
                val filteredCourseAry: ArrayList<Tv_shows> = ArrayList()

                totalAvailble = listvalue1.size

                for (eachsearch in listvalue1) {
                    if (eachsearch.name!!.lowercase().contains(text.lowercase())) {
                        filteredCourseAry.add(eachsearch)
                    }
                }
                if (text.isNotEmpty()) {
                    tvshowAdapter?.sublist(filteredCourseAry)
                } else {
                    tvshowAdapter?.sublist(listvalue1)

                }
               /* tvshowAdapter?.sublist(listvalue1)*/

                tvshowAdapter?.notifyDataSetChanged()
                activitySearchBinding.isLoading = false


            }

        })


    }


}
