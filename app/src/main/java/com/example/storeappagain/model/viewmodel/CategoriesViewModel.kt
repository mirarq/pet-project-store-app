package com.example.storeappagain.model.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeappagain.model.Category
import com.example.storeappagain.model.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesViewModel: ViewModel() {
    private var categoryLiveData = MutableLiveData<List<Category>>()
    fun getCategories() {
        RetrofitInstance.api.getCategories().enqueue(object: Callback<List<Category>>{
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                if(response.body()!=null) {
                    categoryLiveData.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.d("MyLog",t.message.toString())
            }

        })
    }
    fun observeCategoriesLiveData(): LiveData<List<Category>>{
        return categoryLiveData
    }
}


