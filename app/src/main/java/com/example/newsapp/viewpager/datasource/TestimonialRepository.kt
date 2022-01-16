package com.example.newsapp.viewpager.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class TestimonialRepository  {





    private val testimonials = MutableLiveData<List<Testimonial>>()


    fun getTestimonials(): LiveData<List<Testimonial>> {


        /*    testimonials.value = listOf(
                    Testimonial("https://static.episodate.com/images/tv-show/thumbnail/35624.jpg", "1"),
            Testimonial("https://static.episodate.com/images/tv-show/thumbnail/23455.jpg", "1"),
            Testimonial("https://static.episodate.com/images/tv-show/thumbnail/43467.com", "1"),
            Testimonial("https://static.episodate.com/images/tv-show/thumbnail/43234.jpg", "1"),
            Testimonial("https://static.episodate.com/images/tv-show/thumbnail/46692.jpg", "1"))*/



        testimonials.value = listOf(Testimonial(
                testimonialText = "Gabriel is an amazing developer and I'm so appreciative to have him as my Tech Lead, he's pretty too",
                authorText = "Pawełek Grzybek — Junior Developer",
                companyText = "Mindera",
                imageUrl = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg"),

            Testimonial(
                testimonialText = "Gabs is one of the best at what he does, always available for a job, clean, methodical",
                authorText = "Maja T — Przyjaciółka",
                companyText = "Trzebiatowska Crime Family",
                imageUrl = "https://static.episodate.com/images/tv-show/thumbnail/23455.jpg"
            ),
            Testimonial(
                testimonialText =
                "Gabriel is such a mediocre game player he makes me look good, I appreciate that he holds back so much for me",
                authorText = "Ben R — bff",
                companyText = "Loser@Games Co.",
                imageUrl = "https://static.episodate.com/images/tv-show/thumbnail/43234.jpg"
            )
        )
        return testimonials
    }


}