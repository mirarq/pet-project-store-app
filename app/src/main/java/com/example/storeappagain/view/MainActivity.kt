package com.example.storeappagain.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storeappagain.databinding.ActivityMainBinding
import com.example.storeappagain.model.category_adapter.CategoriesAdapter
import com.example.storeappagain.model.viewmodel.CategoriesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        categoriesViewModel = ViewModelProvider(this)[CategoriesViewModel::class.java]
        categoriesViewModel.getCategories()
        categoriesViewModel.observeCategoriesLiveData().observe(this){categoriesList ->
            categoriesAdapter.setCategoryList(categoriesList)
        }


    }
    private fun prepareRecyclerView() = with(binding){
        categoriesAdapter = CategoriesAdapter()
        recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = categoriesAdapter
        }
    }
}