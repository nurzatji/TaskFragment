package com.example.taskfragment.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.widget.ActionBarContainer
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.example.taskfragment.data.local.Pref
import com.example.taskfragment.databinding.FragmentProfileBinding
import com.example.taskfragment.ui.utils.loadImage
import com.google.firebase.auth.FirebaseAuth
import java.lang.System.exit


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref
private val KEY_FOR_RESULT = 10

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK && it.data != null){
            val uri: Uri? = it.data?.data
            pref.setImage(uri.toString())
            binding.imgProfile.loadImage(uri.toString())
        }

        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())

       saveName()
        pref.getImage()?.let { binding.imgProfile.loadImage(it) }
        saveImage()
       exitAccount()
    }

    private fun exitAccount() {
        binding.btnExit.setOnClickListener{
          FirebaseAuth.getInstance().signOut()
            activity?.finish()
        }
    }

    private fun saveImage(){
        binding.imgProfile.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }

    }
    private fun saveName(){
        binding.etText.setText(pref.getUser())
        binding.etText.addTextChangedListener{
            pref.setUser(binding.etText.text.toString())
        }
    }


}

























