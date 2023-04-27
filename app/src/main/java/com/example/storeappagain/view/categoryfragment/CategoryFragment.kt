package com.example.storeappagain.view.categoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storeappagain.R
import com.example.storeappagain.databinding.FragmentCategoryBinding
import com.example.storeappagain.model.adapters.categories.CategoriesAdapter
import com.example.storeappagain.viewmodel.CategoriesViewModel
import com.example.storeappagain.view.selectedcategoryfragment.SelectedCategoryFragment


class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private  val categoriesViewModel: CategoriesViewModel by activityViewModels()
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        categoriesViewModel.getCategories()
        activity?.let {
            categoriesViewModel.observeCategoriesLiveData().observe(viewLifecycleOwner){ categoriesList ->
                categoriesAdapter.setCategoryList(categoriesList)
            }
        }
    }
    private fun prepareRecyclerView() = with(binding){
        categoriesAdapter = CategoriesAdapter()
        recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = categoriesAdapter
            categoryOnClick()
        }
    }
    private fun categoryOnClick() {
        categoriesAdapter.setOnClickListener(object: CategoriesAdapter.OnClickListener {
            override fun onClick(position: Int, category: String) {
                categoriesViewModel.selectedCategoryLiveData.value = category
                val selectedCategory = SelectedCategoryFragment()
                val fragmentManager = parentFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container,selectedCategory)
                fragmentTransaction.addToBackStack("name")
                fragmentTransaction.commit()
            }
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() = CategoryFragment()
    }
}