package com.android.standardhomework3.data.database.di

import android.app.Application
import androidx.room.Room
import com.android.standardhomework3.data.database.FavoriteDao
import com.android.standardhomework3.data.database.FavoriteUserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DataBaseModule {
    @Provides
    fun provideFavoriteUserDataBase(application: Application) : FavoriteUserDataBase {
        return Room.databaseBuilder(
            application,
            FavoriteUserDataBase::class.java,
            "favorite_user_database"
        ).build()
    }

    @Provides
    fun provideFavoriteUserDao(appDatabase: FavoriteUserDataBase) : FavoriteDao {
        return appDatabase.favoriteDao()
    }

}