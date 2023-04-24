package com.example.storeappagain.view.buynowfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.storeappagain.databinding.FragmentBuyNowBinding
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.viewmodel.BuyViewModel
import com.squareup.picasso.Picasso


class BuyNowFragment : Fragment() {
    private val buyViewModel: BuyViewModel by activityViewModels()
    private lateinit var binding: FragmentBuyNowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyNowBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buyViewModel.buyNowLiveData.observe(viewLifecycleOwner){item ->
            bind(item)
        }
        buy()

    }
    private fun bind(item: Category) = with(binding) {
        textViewItemPriceBuyNow.text = "${item.price}$"
        textViewItemTitleBuyNow.text = item.title
        Picasso.get().load(item.image).into(imageViewItemImageBuyNow)
    }

    private fun buy() = with(binding) {
        buttonBuyNow.setOnClickListener {
            context?.let { it1 -> DialogManager.buyNowSettingsDialog(it1) }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = BuyNowFragment()

    }
}