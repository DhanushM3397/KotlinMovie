package com.example.newsapp

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.makeramen.roundedimageview.RoundedImageView


@BindingAdapter("image")
fun ConstraintLayout.background(url:String?){
    if (url.isNullOrEmpty()) return
    Glide.with(this).load(url).into(object : CustomTarget<Drawable>(){

        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
            this@background.background=resource
        }

        override fun onLoadCleared(placeholder: Drawable?) {
           return
        }

    })


}

@BindingAdapter("roundedImageUrl")
fun RoundedImageView.loadImage(url: String?){
    if (url.isNullOrEmpty()) return
    Glide.with(this).load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}


@BindingAdapter("Descimage")
fun ImageView.imageDesc(url: String?){
    if (url.isNullOrEmpty()) return
    Glide.with(this).load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)}


@BindingAdapter("Descimagecaursol")
fun ImageView.caursol(url: String?){
    if (url.isNullOrEmpty()) return
    Glide.with(this).load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)}