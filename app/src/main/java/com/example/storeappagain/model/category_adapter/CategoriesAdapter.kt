package com.example.storeappagain.model.category_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storeappagain.databinding.CategoriesItemBinding
import com.example.storeappagain.model.Category
import com.squareup.picasso.Picasso

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private var categoryList = ArrayList<Category>()
    fun setCategoryList(categoryList:List<Category>){
        this.categoryList = categoryList as ArrayList<Category>
        notifyDataSetChanged()
    }
    class CategoriesViewHolder(val binding: CategoriesItemBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            CategoriesItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        Picasso.get().load(categoryList[position].image).into(holder.binding.imageViewCategory)
        holder.binding.texViewCategoryName.text = categoryList[position].name
    }

}