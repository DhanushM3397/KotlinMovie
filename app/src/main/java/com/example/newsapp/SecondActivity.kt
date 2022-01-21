package com.example.newsapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.coroutine.ListviewModel


import com.example.newsapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var activitySecondBinding: ActivitySecondBinding

    lateinit var viewModel: ListviewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val urlId: String = intent.getStringExtra("id").toString()



        initViewModel1(urlId)

        activitySecondBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_second)// initialization


        //----------------data binding of View Model  to view---------------------------------------------------------

        viewModel.mutableEpisodeLiveData.observe(this, {
            activitySecondBinding.epiDesc = it
        })

        expandableTextview()

    }

    private fun initViewModel1(id: String) {

        //   viewModel = of(this).get(ListviewModel::class.java)    or
        viewModel = ViewModelProvider(this).get(ListviewModel::class.java)

        viewModel.EpisodesInformation(id)

    }

    private fun expandableTextview() {
        activitySecondBinding.textSeeMore.setOnClickListener {
            if (activitySecondBinding.textSeeMore.text.equals("Showmore...")) {
                activitySecondBinding.textView5.maxLines = Int.MAX_VALUE
                activitySecondBinding.textSeeMore.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up,0)
                activitySecondBinding.textSeeMore.text = "Showless"
            } else {
                activitySecondBinding.textView5.maxLines = 3
                activitySecondBinding.textSeeMore.text = "Showmore..."
                activitySecondBinding.textSeeMore.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_down_arrow_down,0)

            }
        }
    }

}