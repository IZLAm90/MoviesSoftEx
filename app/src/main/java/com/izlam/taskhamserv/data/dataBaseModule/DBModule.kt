package com.izlam.taskhamserv.data.dataBaseModule

import android.content.Context
import androidx.room.Room
import com.izlam.taskhamserv.data.AppDB
import com.izlam.taskhamserv.data.PopDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DBModule {
    @Provides
    fun provideChannelDao(appDatabase: AppDB): PopDao {
        return appDatabase.channelDao()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDB {
        return Room.databaseBuilder(
            appContext,
            AppDB::class.java,
            "App"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}