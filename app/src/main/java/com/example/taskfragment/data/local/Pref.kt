package com.example.taskfragment.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.media.Image

class Pref(context:Context) {
    private val pref = context.getSharedPreferences("PREF_NAME",MODE_PRIVATE)


    fun isUserSee():Boolean{
        return pref.getBoolean(SEEN_KEY,false)
    }
    fun saveUserSeen(){
        pref.edit().putBoolean(SEEN_KEY,true).apply()
    }
    fun setUser(name:String){
        pref.edit().putString(PREF_NAME,"").apply()
    }
    fun getUser():String{
        return  pref.getString(PREF_NAME,"").toString()
    }


    fun setImage(image: String){
         pref.edit().putString(PREF_SAVE_IMAGE,image).apply()

    }

    fun getImage(): String? {
       return pref.getString(PREF_SAVE_IMAGE,"")

//    fun saveImage(Image: Image){
//        pref.edit().putString(PREF_SAVE_IMAGE, Image.toString()).apply()
//
//

    }



    companion object{
        const val PREF_SAVE_IMAGE = "pref.image"
        const val PREF_NAME = "pref.task"
        const val SEEN_KEY = "seen.key"

    }
}