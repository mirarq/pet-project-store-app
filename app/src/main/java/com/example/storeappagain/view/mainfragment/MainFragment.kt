package com.example.storeappagain.view.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.storeappagain.databinding.FragmentMainBinding
import com.example.storeappagain.model.adapters.viewpager.VPAdapter
import com.example.storeappagain.view.storefragment.StoreFragment
import com.example.storeappagain.view.basketfragment.BasketFragment
import com.example.storeappagain.view.favoritesfragment.FavoritesFragment
import com.example.storeappagain.view.myaccountfragment.MyAccountFragment
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val fList = listOf(
        StoreFragment.newInstance(),
        FavoritesFragment.newInstance(),
        MyAccountFragment.newInstance(),
        BasketFragment.newInstance()
    )
    private val tList = listOf(
        "Categories",
        "Favorite",
        "My Account",
        "Basket"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }
    private fun init() = with(binding){
        val adapter = VPAdapter(activity as AppCompatActivity,fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout,vp){tab,pos ->
            tab.text = tList[pos]
        }.attach()

    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }

}