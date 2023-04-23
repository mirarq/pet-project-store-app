package com.example.storeappagain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.model.retrofit.RetrofitInstance
import com.example.storeappagain.model.room.repository.FavoriteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesViewModel: ViewModel() {
     var favoriteItemsLiveData = MutableLiveData<List<Category>>()
     var itemSelectedLiveData = MutableLiveData<Category>()
    private var stringLiveData = MutableLiveData<List<String>>()
    private var categoryLiveData = MutableLiveData<List<Category>>()
     var selectedCategoryLiveData = MutableLiveData<String>()
    fun getCategories() {
        RetrofitInstance.api.getCategories().enqueue(object: Callback<List<String>>{
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                if(response.body()!=null) {
                    stringLiveData.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.d("MyLog",t.message.toString())
            }

        })
    }
    fun observeCategoriesLiveData(): LiveData<List<String>>{
        return stringLiveData
    }
    fun observeCategoryLiveData(): LiveData<List<Category>>{
        return categoryLiveData
    }



    fun getSelectedCategory() {
        selectedCategoryLiveData.value?.let { RetrofitInstance.api.getCategoryItems(it)
            .enqueue(object: Callback<List<Category>>{
                override fun onResponse(
                    call: Call<List<Category>>,
                    response: Response<List<Category>>
                ) {
                    if(response.body() != null) {
                        categoryLiveData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                    Log.d("MyLog",t.message.toString())
                }

            }) }
    }
}


