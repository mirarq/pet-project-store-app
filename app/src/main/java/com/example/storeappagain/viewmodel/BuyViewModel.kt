package com.example.storeappagain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeappagain.model.datacllasses.Category

class BuyViewModel: ViewModel() {
     var buyNowLiveData = MutableLiveData<Category>()

}