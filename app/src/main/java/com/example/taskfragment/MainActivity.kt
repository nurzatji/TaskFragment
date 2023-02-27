package com.example.taskfragment

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taskfragment.data.local.Pref
import com.example.taskfragment.databinding.ActivityMainBinding
import com.example.taskfragment.ui.home.HomeFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = Pref(this)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//navController.navigate(HomeFragmentDirections.actionNavigationHomeToOnBoardFragment())


        if (!pref.isUserSee())
            navController.navigate(HomeFragmentDirections.actionNavigationHomeToOnBoardFragment())

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.taskFragment,
                R.id.profileFragment
            )
        )
        val bottonNavFragment = arrayListOf(
            R.id.navigation_home,
            R.id.taskFragment, R.id.profileFragment,
            R.id.navigation_dashboard

        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//      видимый      navView.isVisible =  destination.id  != R.id.taskFragment
            navView.isVisible = bottonNavFragment.contains(destination.id)
            if (destination.id == R.id.onBoardFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()

            }


            navView.setupWithNavController(navController)
        }
    }
}