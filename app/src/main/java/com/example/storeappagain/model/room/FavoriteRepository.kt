package com.example.storeappagain.model.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.storeappagain.model.datacllasses.Category

class FavoriteRepository(private val favoriteDao: FavoriteDao) {
    val allFavorites: LiveData<List<Category>> = favoriteDao.getAllFavorites()

    @WorkerThread
    suspend fun insertFavorite(item:Category) {
        favoriteDao.insertFavorite(item)
    }
    @WorkerThread
    suspend fun deleteFavorite(item:Category) {
        favoriteDao.deleteFavorite(item)
    }
    @WorkerThread
    suspend fun deleteAllFavorites(){
        favoriteDao.deleteAllFavorites()
    }
}