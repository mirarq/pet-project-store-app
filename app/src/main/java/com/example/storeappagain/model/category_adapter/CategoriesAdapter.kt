package com.example.storeappagain.model.category_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storeappagain.databinding.CategoriesItemBinding
import com.squareup.picasso.Picasso

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private var stringList = ArrayList<String>()
    fun setCategoryList(stringList:List<String>){
        this.stringList = stringList as ArrayList<String>
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
        return stringList.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.binding.texViewCategoryName.text = stringList[position]
    }

}