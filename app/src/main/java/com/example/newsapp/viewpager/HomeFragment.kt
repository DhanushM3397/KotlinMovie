package com.example.newsapp.viewpager

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.SCREEN_STATE_OFF
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import com.example.newsapp.R
import com.example.newsapp.coroutine.ListviewModel
import kotlinx.android.synthetic.main.viewtestimonials_layout.view.*
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {


    private val listviewModel: ListviewModel = ListviewModel()

    private val testimonialsAdapter: TestimonialAdapter = TestimonialAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragement, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.testimonials_view_pager.adapter = testimonialsAdapter
        listviewModel.refresh()


       TabLayoutMediator(view.tab_layout, view.testimonials_view_pager) { tab, position ->

        }.attach()




    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listviewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            testimonialsAdapter.submitList(it.toMutableList())
        })


    }



}