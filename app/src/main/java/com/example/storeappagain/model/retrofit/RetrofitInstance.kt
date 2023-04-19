package com.example.storeappagain.model.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: StoreApi by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        Retrofit.Builder()
            .client(client)
            .baseUrl("https://fakestoreapi.com/products/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoreApi::class.java)
    }
}