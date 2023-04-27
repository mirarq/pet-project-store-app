package com.example.storeappagain.model.adapters.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storeappagain.databinding.SelectedCategoryItemBinding
import com.example.storeappagain.model.datacllasses.Category
import com.squareup.picasso.Picasso

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    private var favoriteList = ArrayList<Category>()
    private var onClickListener: OnClickListener? = null
    fun setFavoriteList(favoriteList: List<Category>) {
        this.favoriteList = favoriteList as ArrayList<Category>
        notifyDataSetChanged()

    }

    class FavoriteViewHolder(val binding: SelectedCategoryItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            SelectedCategoryItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoriteList[position]
        with(holder){
            with(binding) {
                textViewTitleRV.text = item.title
                textViewPriceRV.text = "${item.price}$"
                textViewRatingRateRV.text = item.rating?.rate.toString()
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
        fun onClick(position: Int,item:Category)
    }
}