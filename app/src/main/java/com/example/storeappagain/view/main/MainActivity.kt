package com.example.storeappagain.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.storeappagain.R
import com.example.storeappagain.databinding.ActivityMainBinding
import com.example.storeappagain.model.adapters.categories.CategoriesAdapter
import com.example.storeappagain.view.main.basketfragment.BasketFragment
import com.example.storeappagain.view.main.favoritesfragment.FavoritesFragment
import com.example.storeappagain.viewmodel.CategoriesViewModel
import com.example.storeappagain.view.main.myaccountfragment.MyAccountFragment
import com.example.storeappagain.view.main.storefragment.StoreFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = supportActionBar
        loadFragment(StoreFragment.newInstance())
        binding.bottomNav.setOnItemSelectedListener{ item ->
            var fragment: Fragment
            when(item.itemId) {
                R.id.categories -> {
                    toolbar?.title = "Shop"
                    fragment = StoreFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.favorite -> {
                    toolbar?.title = "Favorite"
                    fragment = FavoritesFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.myAccount -> {
                    toolbar?.title = "My Account"
                    fragment = MyAccountFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.basket -> {
                    toolbar?.title = "Basket"
                    fragment = BasketFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }


}