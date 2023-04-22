package com.example.storeappagain.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeappagain.R
import com.example.storeappagain.databinding.ActivityMainBinding
import com.example.storeappagain.model.adapters.categories.CategoriesAdapter
import com.example.storeappagain.viewmodel.CategoriesViewModel
import com.example.storeappagain.view.mainfragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()
    }

}