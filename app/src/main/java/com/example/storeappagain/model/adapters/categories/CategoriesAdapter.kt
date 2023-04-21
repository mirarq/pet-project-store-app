package com.example.storeappagain.model.adapters.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storeappagain.databinding.CategoriesItemBinding

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private var onClickListener: OnClickListener? = null
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
        val category = stringList[position]
        holder.binding.texViewCategoryName.text = category
        holder.itemView.setOnClickListener {
            if(onClickListener != null) {
                onClickListener!!.onClick(position,category)
            }
        }

    }
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, category: String)
    }
}