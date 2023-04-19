package com.example.storeappagain.model.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeappagain.model.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesViewModel: ViewModel() {
    private var stringLiveData = MutableLiveData<List<String>>()
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
}


