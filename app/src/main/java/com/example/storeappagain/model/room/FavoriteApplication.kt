package com.example.storeappagain.model.room

import android.app.Application
import com.example.storeappagain.model.room.FavoriteDatabase
import com.example.storeappagain.model.room.FavoriteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class FavoriteApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { FavoriteDatabase.getDatabase(this) }
    val repository by lazy { FavoriteRepository(database.favoriteDao()) }
}