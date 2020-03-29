package com.example.jetpackapp.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackapp.R

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(
    uri: String?, circularProgressDrawable: CircularProgressDrawable = getProgressDrawable(context)
) {
    val options = RequestOptions().apply {
        placeholder(getProgressDrawable(context))
        error(R.mipmap.ic_dog)
    }

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}