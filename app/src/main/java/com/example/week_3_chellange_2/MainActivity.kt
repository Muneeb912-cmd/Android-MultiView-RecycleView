package com.example.week_3_chellange_2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.week_3_chellange_2.adapters.MultiViewAdapter
import com.example.week_3_chellange_2.databinding.ActivityMainBinding
import com.example.week_3_chellange_2.model.ImageModel
import com.example.week_3_chellange_2.model.TextModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MultiViewAdapter(this, getItems())
        binding.recyclerView.adapter = adapter

        // Initialize DrawerLayout and Toolbar
        drawerLayout = binding.main
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // Initialize NavigationView and set its listener
        val navigationView = binding.navMenu
        navigationView.setNavigationItemSelectedListener(this)

        // Setup ActionBarDrawerToggle
        val toggle = actionBarDrawerToggle(toolbar)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }


    private fun getItems(): MutableList<Any> {
        return mutableListOf(
            TextModel("Person 1", "Android Developer", R.drawable.sample_logo),
            TextModel("Person 2", "Android Developer", R.drawable.sample_logo),
            ImageModel("This is just dummy description about this image", R.drawable.img_1),
            TextModel("Person3", "Android Developer", R.drawable.sample_logo),
            ImageModel("This is just dummy description about this image", R.drawable.img_1),
            ImageModel("This is just dummy description about this image", R.drawable.img_1),
            TextModel("person 4", "Android Developer", R.drawable.img_1),
        )
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    private fun actionBarDrawerToggle(toolbar: Toolbar?) =
        ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
}

