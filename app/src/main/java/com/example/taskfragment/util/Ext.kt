package com.example.taskfragment.ui.utils

import android.os.Message
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.taskfragment.databinding.FragmentAuthBinding


fun  ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}
fun  Fragment.showToast(message: String){
    Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT)
        .show()
}