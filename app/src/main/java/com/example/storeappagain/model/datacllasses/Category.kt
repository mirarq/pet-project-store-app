package com.example.storeappagain.model.datacllasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "favoriteTable")
data class Category(
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "price")
    val price: String?,
    @ColumnInfo(name = "category")
    val category: String?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "image")
    val image: String?,
    @ColumnInfo(name = "rating")
    val rating: Rating?,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    var itemid: Int? = null
)
