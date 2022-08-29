package com.izlam.taskhamserv.localData

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DBModule {
    @Provides
    fun provideDao(dp: AppDB):Dao{
        return dp.appDao()
    }

    @Provides
    @Singleton
    fun provideAppDB(@ApplicationContext appContext:Context):AppDB{
        return Room.databaseBuilder(
            appContext,
            AppDB::class.java,
            "islam"
        ).build()
    }

}