package com.example.storeappagain.view.itemfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.storeappagain.R
import com.example.storeappagain.databinding.FragmentItemBinding
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.viewmodel.CategoriesViewModel
import com.squareup.picasso.Picasso




class ItemFragment : Fragment() {
    private lateinit var binding: FragmentItemBinding
    private val categoriesViewModel: CategoriesViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesViewModel.itemSelectedLiveData.observe(viewLifecycleOwner){item ->
            bind(item)
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
        imageViewAddToFavorite.setOnClickListener {
            categoriesViewModel.favoriteItemsLiveData.value = listOf(item)
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = ItemFragment()
    }
}