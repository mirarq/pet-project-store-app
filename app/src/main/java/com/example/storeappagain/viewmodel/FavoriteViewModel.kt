package com.example.storeappagain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.storeappagain.model.datacllasses.Category
import com.example.storeappagain.model.room.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository): ViewModel() {
    val allFavorites: LiveData<List<Category>> = repository.allFavorites

    fun insertFavorite(item: Category) = viewModelScope.launch {
        repository.insertFavorite(item)
        Log.d("MyLog","Insert: $item")
    }
    fun deleteFavorite(item:Category) = viewModelScope.launch {
        repository.deleteFavorite(item)
        Log.d("MyLog","Delete: $item")
    }
    fun deleteAllFavorites() = viewModelScope.launch {
        repository.deleteAllFavorites()
    }
}
class FavoriteViewModelFactory(private val repository: FavoriteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}