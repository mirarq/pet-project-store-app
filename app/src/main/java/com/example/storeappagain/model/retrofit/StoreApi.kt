package com.example.storeappagain.model.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface StoreApi {
    @GET("categories")
     fun getCategories(): Call<List<String>>
}