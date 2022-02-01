package com.example.newsapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager


import com.example.newsapp.adapter.RecylerNewsAdapter
import com.example.newsapp.paging.PagingTvlistAdapter
import com.example.newsapp.coroutine.ListviewModel
import com.example.newsapp.databinding.ActivityMainBinding


import com.example.newsapp.modelClass.Tv_shows
import com.example.newsapp.paging.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest


class MainActivity : AppCompatActivity() {
    lateinit var pagingTvlistAdapter: PagingTvlistAdapter


    lateinit var viewModel: ListviewModel

    var recylerNewsAdapter: RecylerNewsAdapter? = null
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.imgSearch.setOnClickListener {

            val searchint = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(searchint)

        }


        initViewModel()
        initRecycler()

        initPagingRecycler1()
        initPagingViewModel1()


    }


    private fun initRecycler() {
        activityMainBinding.isLoading = true
        if (checkForInternet(this)) {
            activityMainBinding.recycler.apply {
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)


                //---------------Staggered Grid with vertical Orientation------------------------------
                /*  layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)*/


                setHasFixedSize(true)
                activityMainBinding.recycler.isVisible = true   //visibility
                //---------onitem Click----------------------------------------
                recylerNewsAdapter = RecylerNewsAdapter(RecylerNewsAdapter.OnClickListener { name ->


                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("id", name.id)


                    /*
                        intent.putExtra("imageUrl", name.image_thumbnail_path)
                        intent.putExtra("name", name.name)
                        intent.putExtra("startTime", name.start_date)
                       */
                    startActivity(intent)

                    viewModel.EpisodesInformation(name.id)


                })
                adapter = recylerNewsAdapter

                observeViewModel()
            }
        } else {
            activityMainBinding.recycler.isVisible = false
            Toast.makeText(this, "Please Turn on Your Internet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewModel() {

        activityMainBinding.isLoading = false
        //   viewModel = of(this).get(ListviewModel::class.java)    or
        // Get the view model

        viewModel = ViewModelProvider(this).get(ListviewModel::class.java)

        viewModel.refresh()

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun observeViewModel() {
        viewModel.mutableLiveData.observe(this, { updateItems ->
            updateItems?.let {

                recylerNewsAdapter?.sublist(it as ArrayList<Tv_shows>)
                recylerNewsAdapter?.notifyDataSetChanged()

            }

        })


    }


    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }


    }


    private fun initPagingRecycler1() {
        if (checkForInternet(this)) {
            activityMainBinding.recyclerView1.apply {
                /*layoutManager =
                     LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)*/
                //---------------Staggered Grid with vertical Orientation------------------------------
                layoutManager =
                    StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)


                val decoration =
                    DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
                recyclerView1.addItemDecoration(decoration)
                val decoration1 =
                    DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
                recyclerView1.addItemDecoration(decoration1)

                setHasFixedSize(true)


                pagingTvlistAdapter =
                    PagingTvlistAdapter(PagingTvlistAdapter.OnPagingItemClick { name ->
                        Toast.makeText(
                            applicationContext,
                            name.tv_shows[0].name,
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                adapter = pagingTvlistAdapter


            }
        } else {
            activityMainBinding.recycler.isVisible = false
            Toast.makeText(this, "Please Turn on Your Internet", Toast.LENGTH_SHORT).show()
        }
    }


    private fun initPagingViewModel1() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                pagingTvlistAdapter.submitData(it)
            }
        }
    }


}