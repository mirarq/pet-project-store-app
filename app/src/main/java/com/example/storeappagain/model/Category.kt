package com.example.storeappagain.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("creationAt")
    val creationAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)