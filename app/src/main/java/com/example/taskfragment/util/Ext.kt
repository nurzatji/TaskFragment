package com.example.taskfragment.ui.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun  ImageView.loadImage(url:String){
    Picasso.get().load("https://site.surveysparrow.com/wp-content/uploads/2021/10/employee-onboarding-survey-questions-768x410.png").into(this)
}