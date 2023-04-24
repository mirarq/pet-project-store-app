package com.example.storeappagain.model.datacllasses


data class Category(
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
    val rating: Rating
)
