package com.example.storeappagain.view.storefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.storeappagain.R
import com.example.storeappagain.databinding.FragmentStoreBinding
import com.example.storeappagain.view.categoryfragment.CategoryFragment


class StoreFragment : Fragment() {
    private lateinit var binding: FragmentStoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater,container,false)
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frame,CategoryFragment()).commit()
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = StoreFragment()
    }
}