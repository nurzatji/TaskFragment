package com.example.taskfragment.ui.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskfragment.R
import com.example.taskfragment.data.local.Pref
import com.example.taskfragment.databinding.FragmentOnBoardBinding
import com.example.taskfragment.ui.onBoarding.Adapter.onBoardingAdapter
import me.relex.circleindicator.CircleIndicator3

class onBoardFragment : Fragment() {
private lateinit var pref: Pref
private lateinit var binding: FragmentOnBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentOnBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref =Pref(requireContext())
        val adapter = onBoardingAdapter(){
            pref.saveUserSeen()
            findNavController().navigate(onBoardFragmentDirections.actionOnBoardFragmentToNavigationHome())

        }
        binding.viewPager.adapter= adapter
        indicator()
    }

    private fun indicator() {
        val indicator:CircleIndicator3 = binding.indicator
    val viewPager = binding.viewPager
    indicator.setViewPager(viewPager)
    }

}