package com.example.storeappagain.view.selectedcategoryfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storeappagain.databinding.FragmentSelectedCategoryBinding
import com.example.storeappagain.model.adapters.selectedcategory.SelectedCategoryAdapter
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.viewmodel.CategoriesViewModel

class SelectedCategoryFragment : Fragment() {
    private lateinit var binding: FragmentSelectedCategoryBinding
    private val categoriesViewModel: CategoriesViewModel by activityViewModels()
    private lateinit var adapterSelectedCategory: SelectedCategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSelectedCategoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRv()
        categoriesViewModel.getSelectedCategory()
        activity?.let {
            categoriesViewModel.observeCategoryLiveData().observe(viewLifecycleOwner){categoryItemsList ->
                adapterSelectedCategory.setSelectedCategoryItemsList(categoryItemsList)
            }
        }

    }

    private fun prepareRv() = with(binding){
        adapterSelectedCategory = SelectedCategoryAdapter()
        recyclerViewSelectedCategory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSelectedCategory
            itemOnClick()
        }
    }
    private fun itemOnClick() {
        adapterSelectedCategory.setOnClickListener(object: SelectedCategoryAdapter.OnClickListener{
            override fun onClick(position: Int, item: Category) {
                    val fragmentManager = parentFragmentManager
                     fragmentManager.beginTransaction()
                        .remove(this@SelectedCategoryFragment).commit()



            }

        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = SelectedCategoryFragment()
    }
}