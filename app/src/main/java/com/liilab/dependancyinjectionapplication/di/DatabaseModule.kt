package com.liilab.dependancyinjectionapplication.di

import android.content.Context
import androidx.room.Room
import com.liilab.dependancyinjectionapplication.data.datasource.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "note-db"
        ).build()

    @Singleton
    @Provides
    fun provideNoteDao(database: AppDatabase) = database.noteDao()

}