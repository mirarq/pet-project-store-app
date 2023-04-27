package com.example.storeappagain.model.room

import androidx.room.TypeConverter
import com.example.storeappagain.model.datacllasses.Rating
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromRating(rating: Rating): String? {
        return Gson().toJson(rating)
    }
    @TypeConverter
    fun fromList(json: String): Rating {
        return Gson().fromJson(json,Rating::class.java)
    }
}