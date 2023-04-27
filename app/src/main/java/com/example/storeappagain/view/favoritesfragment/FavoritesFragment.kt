package com.example.storeappagain.view.favoritesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storeappagain.R
import com.example.storeappagain.databinding.FragmentFavoritesBinding
import com.example.storeappagain.model.adapters.favorite.FavoriteAdapter
import com.example.storeappagain.model.adapters.selectedcategory.SelectedCategoryAdapter
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.model.room.FavoriteApplication
import com.example.storeappagain.view.itemfragment.ItemFragment
import com.example.storeappagain.viewmodel.CategoriesViewModel
import com.example.storeappagain.viewmodel.FavoriteViewModel
import com.example.storeappagain.viewmodel.FavoriteViewModelFactory


class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val favoriteViewModel:FavoriteViewModel by  viewModels {
        FavoriteViewModelFactory((activity?.application as FavoriteApplication).repository)
    }
    private val categoriesViewModel: CategoriesViewModel by activityViewModels()
    private lateinit var favoriteAdapter: FavoriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRv()
        activity?.let {
            favoriteViewModel.allFavorites.observe(viewLifecycleOwner) {favoriteList ->
                favoriteAdapter.setFavoriteList(favoriteList)
            }
        }
    }
    private fun prepareRv() = with(binding){
        favoriteAdapter = FavoriteAdapter()
        recyclerViewFavorite.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteAdapter
            itemOnClick()
        }
    }
    private fun itemOnClick() {
        favoriteAdapter.setOnClickListener(object: FavoriteAdapter.OnClickListener{
            override fun onClick(position: Int, item: Category) {
                categoriesViewModel.itemSelectedLiveData.value = item
                val itemFragment = ItemFragment()
                val fragmentManager = parentFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container,itemFragment)
                fragmentTransaction.addToBackStack("selectedCategory")
                fragmentTransaction.commit()
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance() = FavoritesFragment()
    }
}