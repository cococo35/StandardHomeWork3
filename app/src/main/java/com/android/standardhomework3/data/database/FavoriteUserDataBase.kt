package com.android.standardhomework3.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.standardhomework3.data.database.entity.FavoriteUserEntity

@Database(
    entities = [
        FavoriteUserEntity::class
    ],
    version = 1
)

abstract class FavoriteUserDataBase : RoomDatabase() {
    abstract fun favoriteDao() : FavoriteDao
}
