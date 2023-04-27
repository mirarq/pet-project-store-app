package com.example.storeappagain.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.storeappagain.model.datacllasses.Category
import java.util.concurrent.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(item:Category)

    @Delete
    suspend fun deleteFavorite(item:Category)

    @Update
    suspend fun updateFavorite(item:Category)

    @Query("Select * from favoriteTable order by item_id ASC")
    fun getAllFavorites(): LiveData<List<Category>>

    @Query("DELETE FROM favoriteTable")
    suspend fun deleteAllFavorites()

}