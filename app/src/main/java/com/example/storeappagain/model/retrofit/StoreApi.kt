package com.example.storeappagain.model.retrofit

import com.example.storeappagain.model.datacllasses.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {
    @GET("categories")
     fun getCategories(): Call<List<String>>

     @GET("https://fakestoreapi.com/products/category/{category}")
     fun getCategoryItems(@Path("category") category: String ): Call<List<Category>>
}