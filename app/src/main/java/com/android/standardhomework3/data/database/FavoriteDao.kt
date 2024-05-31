package com.android.standardhomework3.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.standardhomework3.data.database.entity.FavoriteUserEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteUser(favoriteUser: FavoriteUserEntity)

    @Query("SELECT * FROM FavoriteUserEntity")
    suspend fun getUsers(): List<FavoriteUserEntity>

}