package com.example.newsapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.DaoDatabase.EpisodeEntiity
import com.example.newsapp.R
import com.example.newsapp.SecondActivity
import com.example.newsapp.adapter.BottomSheetAdapter
import com.example.newsapp.adapter.RecylerNewsAdapter
import com.example.newsapp.coroutine.Roomviewmodel
import com.example.newsapp.databinding.FragmentBlankBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*


class BlankFragment : BottomSheetDialogFragment() {
    //lateinit var bottomSheetAdapter: BottomSheetAdapter
    lateinit var fragmentBlankBinding: FragmentBlankBinding
    private lateinit var model: Roomviewmodel
    lateinit var retriveroomdata: List<EpisodeEntiity>

    fun newInstance(): BlankFragment {
        return BlankFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBlankBinding = FragmentBlankBinding.inflate(inflater, container, false)

        model = ViewModelProvider(this).get(Roomviewmodel::class.java)
     /* BottomsheetRecyclerview()
        dataBindingFromRoomDb()*/
        return fragmentBlankBinding.root
    }

  /* private fun BottomsheetRecyclerview() {
        fragmentBlankBinding.bottomRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = bottomSheetAdapter

        }

    }*/

   /* private fun dataBindingFromRoomDb() {
        model.students.observe(this, {name->

            bottomSheetAdapter.bottomsublist(name)

            bottomSheetAdapter?.notifyDataSetChanged()
        })

    }*/


}

