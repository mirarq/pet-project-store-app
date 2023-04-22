package com.example.storeappagain.model.adapters.selectedcategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storeappagain.databinding.SelectedCategoryItemBinding
import com.example.storeappagain.model.datacllasses.Category
import com.squareup.picasso.Picasso

class SelectedCategoryAdapter:
    RecyclerView.Adapter<SelectedCategoryAdapter.SelectedCategoryViewHolder>() {
    private var itemList = ArrayList<Category>()
    private var onClickListener: OnClickListener? = null
    fun setSelectedCategoryItemsList(itemList: List<Category>) {
        this.itemList = itemList as ArrayList<Category>
        notifyDataSetChanged()
    }
    class SelectedCategoryViewHolder(val binding: SelectedCategoryItemBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedCategoryViewHolder {
        return SelectedCategoryViewHolder(
            SelectedCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: SelectedCategoryViewHolder, position: Int) {
        val item = itemList[position]
        with(holder){
            with(binding){
                textViewTitleRV.text = item.title
                textViewPriceRV.text = "${item.price}$"
                textViewRatingRateRV.text = item.rating.rate.toString()
                Picasso.get().load(item.image).into(imageViewIconInRV)
            }
            itemView.setOnClickListener {
                if(onClickListener != null) {
                    onClickListener!!.onClick(position,item)
                }
            }
        }
    }
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int,item: Category)
    }

}