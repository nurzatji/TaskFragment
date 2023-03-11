package com.example.taskfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taskfragment.data.local.Pref
import com.example.taskfragment.databinding.ActivityMainBinding
import com.example.taskfragment.ui.auth.AuthFragmentDirections
import com.example.taskfragment.ui.home.HomeFragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: Pref
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = Pref(this)
        auth = FirebaseAuth.getInstance()
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        if (auth.currentUser?.uid == null) {
            navController.navigate(HomeFragmentDirections.actionToAuth())
        } else if (!pref.isUserSee())
            navController.navigate(HomeFragmentDirections.actionNavigationHomeToOnBoardFragment())


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.taskFragment,
                R.id.profileFragment,
                R.id.authFragment
            )
        )
        val bottomNavFragment = arrayListOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications,
            R.id.img_profile,
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            navView.isVisible = bottomNavFragment.contains(destination.id)//Start
            if (destination.id == R.id.onBoardFragment) {
                supportActionBar?.hide()
            } else supportActionBar?.show()
//            navView.isVisible = destination.id != R.id.taskFragment
        }
        navView.setupWithNavController(navController)

        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            Log.d("ololo", "token:$it")

        }
    }
}


