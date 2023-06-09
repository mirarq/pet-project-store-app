package com.example.storeappagain.view.main.itemfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.storeappagain.R
import com.example.storeappagain.databinding.FragmentItemBinding
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.model.room.FavoriteApplication
import com.example.storeappagain.view.main.buynowfragment.BuyNowFragment
import com.example.storeappagain.viewmodel.BuyViewModel
import com.example.storeappagain.viewmodel.CategoriesViewModel
import com.example.storeappagain.viewmodel.FavoriteViewModel
import com.example.storeappagain.viewmodel.FavoriteViewModelFactory
import com.squareup.picasso.Picasso
class ItemFragment : Fragment() {
    private lateinit var binding: FragmentItemBinding
    private val categoriesViewModel: CategoriesViewModel by activityViewModels()
    private val buyNowViewModel: BuyViewModel by activityViewModels()
    private val newFavoriteActivityRequestCode = 1
    private val favoriteViewModel: FavoriteViewModel by viewModels {
        FavoriteViewModelFactory((activity?.application as FavoriteApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriesViewModel.itemSelectedLiveData.observe(viewLifecycleOwner) { item ->
            bind(item)
            buyNow(item)
            addToFavorite(item)
        }
    }

    private fun bind(item: Category) = with(binding) {
        Picasso.get().load(item.image).into(imageViewItemImage)
        textViewItemTitle.text = item.description
        textViewItemDescription.text = item.description
        textViewItemPrice.text = "${item.price}$"
    }

    private fun addToFavorite(item: Category) = with(binding) {
        var countClicks = 1
        imageViewAddToFavorite.setOnClickListener {
            if (countClicks % 2 == 0) {
                favoriteViewModel.insertFavorite(item)
                textViewAddToFavoriteList.isVisible = false
                imageViewAddToFavorite.setImageResource(R.drawable.baseline_star_24)
                countClicks += 1
            } else {
                favoriteViewModel.deleteFavorite(item)
                textViewAddToFavoriteList.isVisible = true
                imageViewAddToFavorite.setImageResource(R.drawable.baseline_star_outline_24)
                countClicks += 1
            }

        }
    }
    private fun buyNow(item: Category) = with(binding) {
        buttonBuyNowItem.setOnClickListener {
            buyNowViewModel.buyNowLiveData.value = item
            val buyNowFragment = BuyNowFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,buyNowFragment)
            fragmentTransaction.addToBackStack("selectedCategory")
            fragmentTransaction.commit()
        }
    }




    companion object {

        @JvmStatic
        fun newInstance() = ItemFragment()
    }
}