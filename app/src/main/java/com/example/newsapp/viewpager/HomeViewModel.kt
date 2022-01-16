package com.example.newsapp.viewpager

import androidx.lifecycle.ViewModel
import com.example.newsapp.viewpager.datasource.TestimonialRepository

class HomeViewModel: ViewModel() {

    private val testimonialRepository = TestimonialRepository()
    val testimonials = testimonialRepository.getTestimonials()
}